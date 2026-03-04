class Solution {
public:
    int climb(int n , vector<int>& dp) {
       
       if(n<=0){
         return n+1;
       }

       if(dp[n] != -1){
        return dp[n];
       }
       int pick=climb(n-1,dp);
       int skip=climb(n-2,dp);

       return dp[n]=pick+skip;
    }
    int climbStairs(int n) {
        vector<int>dp(n+1,-1);
        return climb(n , dp);
    }
};