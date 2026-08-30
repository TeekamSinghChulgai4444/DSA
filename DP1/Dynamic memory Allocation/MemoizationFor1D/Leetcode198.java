package MemoizationFor1D;

import java.util.Arrays;

public class Leetcode198 {

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    private static int solve(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = nums[i] + solve(i + 2, nums, dp);
        int skip = solve(i + 1, nums, dp);

        dp[i] = Math.max(rob, skip);
        return dp[i];
    }

    // Optional main for local testing
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums)); // Output: 12
    }
}