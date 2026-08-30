package Knapsack;

import java.util.Arrays;

public class Leetcode494 {

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int x : nums) sum += x;

        // target out of possible range
        if (Math.abs(target) > sum) return 0;

        int n = nums.length;
        int[][] dp = new int[n][2 * sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(nums, 0, target, sum, dp);
    }

    private int dfs(int[] nums, int idx, int target, int sum, int[][] dp) {

        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (dp[idx][target + sum] != -1) {
            return dp[idx][target + sum];
        }

        int add = dfs(nums, idx + 1, target - nums[idx], sum, dp);
        int sub = dfs(nums, idx + 1, target + nums[idx], sum, dp);

        return dp[idx][target + sum] = add + sub;
    }

    public static void main(String[] args) {
        Leetcode494 obj = new Leetcode494();
        int[] arr = {1, 1, 1, 1, 1, 1};
        int target = 5;

        System.out.println("Answer: " + obj.findTargetSumWays(arr, target));
    }
}