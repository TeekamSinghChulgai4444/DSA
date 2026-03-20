#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int LPS(string &s1 , int i , string &s2 , int j , vector<vector<int>>& dp) {
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1[i] == s2[j]){
            return dp[i][j] = 1 + LPS(s1, i-1, s2, j-1, dp);
        }

        return dp[i][j] = max(
            LPS(s1, i-1, s2, j, dp),
            LPS(s1, i, s2, j-1, dp)
        );
    }

    int longestPalindromeSubseq(string s) {
        int l = s.length();

        string s1 = s;
        string s2 = s;

        reverse(s2.begin(), s2.end());

        vector<vector<int>> dp(l, vector<int>(l, -1));

        return LPS(s1, l-1, s2, l-1, dp); 
    }
};