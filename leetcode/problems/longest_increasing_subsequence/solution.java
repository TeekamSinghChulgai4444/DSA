import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 1; i < n; i++) {
          
            int j=i-1;

            while(j>=0){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                j--;
            }
            
            ans=Math.max(ans,dp[i]);
        }

        return ans;
    }
}