package MemoizationFor1D;

import java.util.Arrays;

public class Leetcode746 {

    static int[] dp;

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        // You can start from step 0 or step 1
        return Math.min(solve(0, cost), solve(1, cost));
    }

    private static int solve(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(
                solve(i + 1, cost),
                solve(i + 2, cost)
        );

        return dp[i];
    }

    // Optional main for testing
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost)); // 15
    }
}