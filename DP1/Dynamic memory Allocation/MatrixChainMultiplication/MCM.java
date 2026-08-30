package MatrixChainMultiplication;

import java.util.Arrays;

public class MCM {

    public int cost(int i, int j, int[] arr, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int x = arr[i - 1] * arr[k] * arr[j];

            int ct = cost(i, k, arr,dp
            ) + cost(k + 1, j, arr,dp) + x;

            minCost = Math.min(minCost, ct);
        }


        return dp[i][j]=minCost;
    }

    public static void main(String[] args) {
        int[] matrix = {1, 2, 3, 4, 5, 6};
        int l = matrix.length;

        MCM obj = new MCM();
        int dp[][]=new int[l][l];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }


        int ans = obj.cost(1, l - 1, matrix,dp);

        System.out.println("Answer : " + ans);
    }
}