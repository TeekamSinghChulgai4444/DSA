package UniqueBinarySearchTree;

import java.util.Arrays;

public class L300 {

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [] dp = new int[n];

        Arrays.fill(dp ,1);
        int ans=1;
        for(int i=1;i<n;i++){
            int mx=0;
            int j=i-1;

            while(j>=0){
                if(nums[j]<=nums[i]){
                    mx=Math.max(mx,dp[j]);
                }
                j--;
            }
            dp[i]=mx+1;
            ans=Math.max(ans,dp[i]);
        }
        return ans;

    }
    public static void main(String[] args) {

        L300 obj = new L300();

        int[] nums={10,9,2,5,3,7,101,18};

        int ans=obj.lengthOfLIS(nums);

        System.out.println("Answer :"+ans);

    }
}
