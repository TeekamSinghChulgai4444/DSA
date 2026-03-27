class Solution {
    public int[] check(int[] nums, int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j--;
            }
        }

        return dp;

    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] dpp = new int[n];
        Arrays.fill(dpp, 1);

        dp = check(nums, n);

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n) {
                if (nums[j] < nums[i]) {
                    dpp[i] = Math.max(dpp[i], dpp[j] + 1);
                }
                j++;
            }
        }
        int mx = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] > 1 && dpp[i] > 1) {
                mx = Math.max(mx, dp[i] + dpp[i] - 1);
            }
        }

        return n - mx ;

    }
}