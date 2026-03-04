import java.util.Arrays;

class Solution {

    public int LPS(StringBuilder A, StringBuilder B, int n, int m, int[][] dp) {
        
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (A.charAt(n - 1) == B.charAt(m - 1)) {
            dp[n][m] = 1 + LPS(A, B, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(
                    LPS(A, B, n - 1, m, dp),
                    LPS(A, B, n, m - 1, dp)
            );
        }

        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int m = n;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringBuilder A = new StringBuilder(s);
        String reversed = new StringBuilder(s).reverse().toString();
        StringBuilder B = new StringBuilder(reversed);

        return LPS(A, B, n, m, dp);
    }
}