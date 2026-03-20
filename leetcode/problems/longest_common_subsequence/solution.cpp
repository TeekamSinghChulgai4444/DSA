class Solution {
public:
    int  helper(string & str1,int i , string &str2 , int j , vector<vector<int>>&dp) {
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]  != -1){
           return  dp[i][j];
        }

        if(str1[i]==str2[j]){
            return dp[i][j]=1+helper(str1 ,i-1, str2 ,j-1,dp);
        }
        else{
            return dp[i][j]=max(helper(str1 ,i, str2 ,j-1,dp),helper(str1 ,i-1, str2 ,j,dp));
        }

    }

    int longestCommonSubsequence(string text1, string text2) {
        int i=text1.length();
        int j=text2.length();

        vector<vector<int>>dp(i,vector<int>(j, -1));

        return helper(text1 , i-1  , text2 , j-1 , dp);

    }
};