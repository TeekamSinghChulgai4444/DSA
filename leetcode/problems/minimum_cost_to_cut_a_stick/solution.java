

import java.util.*;
class Solution {
    public int helper(int i, int j,int[][] dp ,int[] cuts) {

        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int cost = Integer.MAX_VALUE;

        for(int k=i;k<=j;k++){
            int x=cuts[j+1]-cuts[i-1];
            int val=helper(i,k-1,dp,cuts)+helper(k+1,j,dp,cuts);
            cost=Math.min(cost,x+val);
        }

        return dp[i][j]=cost;
       
        
    }
    public int minCost(int n, int[] cuts) {
        int l=cuts.length;
        Arrays.sort(cuts);

        int [] newcuts=new int[l+2];

        newcuts[0]=0;
        newcuts[l+1]=n;

        for(int i=0;i<l;i++){
            newcuts[i+1]=cuts[i];
        }

        int[][] dp=new int[l+2][l+2];

        for(int i=0;i<l+2;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(1,l,dp,newcuts);        
    }
}