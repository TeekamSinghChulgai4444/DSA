import java.util.Arrays;

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(nums, 0, target, sum, dp);
    }

    private int dfs(int[] nums, int idx, int target, int sum, int[][] dp) {

        // ✅ CRITICAL BOUNDS CHECK (FIX)
        if (target > sum || target < -sum) return 0;

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
}