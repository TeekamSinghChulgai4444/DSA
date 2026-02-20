class Solution {
    public int amount(int[] cost, int i, int[] dp) {

        if (i >= cost.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int take = cost[i] + amount(cost, i + 2, dp);
        int skip = amount(cost, i + 1, dp);

        return dp[i] = Math.max(take, skip);

    }

    public int rob(int[] cost) {
        int l = cost.length;
        int[] dp = new int[l];
        Arrays.fill(dp, -1);

        return amount(cost, 0, dp);

    }
}