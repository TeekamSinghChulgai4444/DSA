import java.util.Arrays;

class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, target, dp);
    }

    private boolean solve(int[] nums, int i, int target, int[][] dp) {

        if (target == 0) return true;
        if (i >= nums.length) return false;

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean skip = solve(nums, i + 1, target, dp);

        boolean take = false;
        if (nums[i] <= target) {
            take = solve(nums, i + 1, target - nums[i], dp);
        }

        dp[i][target] = (skip || take) ? 1 : 0;
        return dp[i][target] == 1;
    }
}