import java.util.Arrays;

class Solution {

    static final int INF = 1000000;

    public int fun(int[] arr, int i, int target, int[][] dp) {

        if (target == 0) {
            return 0;
        }

        if (i == arr.length) {
            return INF;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        // Skip current coin
        int skip = fun(arr, i + 1, target, dp);

        // Take current coin (unbounded)
        int take = INF;
        if (arr[i] <= target) {
            take = 1 + fun(arr, i, target - arr[i], dp);
        }

        return dp[i][target] = Math.min(skip, take);
    }

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = fun(coins, 0, amount, dp);

        return (ans == INF) ? -1 : ans;
    }
}