class Solution {
public:

    int MSD(string s , string s2 , int i ,int j , vector<vector<int>>&dp){
        if(i==0 || j==0){
            return (i==0)?j:i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s[i-1]==s2[j-1]){
            return dp[i][j]= MSD(s, s2, i-1, j-1, dp);
        }
        else{
            int del = MSD(s, s2, i-1, j, dp);
            int rep = MSD(s, s2, i-1, j-1, dp);
            int ins = MSD(s, s2, i, j-1, dp);
            return dp[i][j]=1+min(del,min(rep,ins));
        }
    }

    int minDistance(string str, string str2) {
        int n=str.length();
        int m=str2.length();
        vector<vector<int>>dp(n+1,vector<int>(m+1,-1));

        return MSD( str,  str2, n, m , dp);
    }
};