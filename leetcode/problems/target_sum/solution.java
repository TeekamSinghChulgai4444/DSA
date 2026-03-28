import java.util.Arrays;

class Solution {

    public int helper(int[] nums, int i, int sum, int target, int[][] dp, int offset) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + offset] != -1) {
            return dp[i][sum + offset];
        }

        int add = helper(nums, i + 1, sum + nums[i], target, dp, offset);
        int subtract = helper(nums, i + 1, sum - nums[i], target, dp, offset);

        return dp[i][sum + offset] = add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(nums, 0, 0, target, dp, sum);
    }
}