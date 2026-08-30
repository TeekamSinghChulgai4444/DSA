package MatrixChainMultiplication;

import java.util.Arrays;

public class L1547 {

    public int helper(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int cost = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int val = (cuts[j + 1] - cuts[i - 1]) + helper(i, k - 1, cuts, dp) + helper(k + 1, j, cuts, dp);

            cost = Math.min(cost, val);
        }

        return dp[i][j] = cost;
    }

    public int minCost(int n, int[] cuts) {
        int l = cuts.length;

        int[] newCuts = new int[l + 2];
        newCuts[0] = 0;
        newCuts[l + 1] = n;

        for (int i = 0; i < l; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[l + 2][l + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(1, l, newCuts, dp);
    }
}