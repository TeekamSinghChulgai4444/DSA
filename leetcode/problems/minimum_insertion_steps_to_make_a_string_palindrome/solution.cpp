class Solution {
public:
    int LPS(string &s , int i , int j , vector<vector<int>>& dp){

        if(i >= j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s[i] == s[j]){
            return dp[i][j] = LPS(s, i+1, j-1, dp);
        }

        return dp[i][j] = 1 + min(
            LPS(s, i+1, j, dp),
            LPS(s, i, j-1, dp)
        );
    }

    int minInsertions(string s) {

        int n = s.length();

        vector<vector<int>> dp(n, vector<int>(n, -1)); 

        return LPS(s, 0, n-1, dp);
    }
};