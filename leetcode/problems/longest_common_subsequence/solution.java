class Solution {

    public int LCS(StringBuilder a, StringBuilder b, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            dp[n][m] = 1 + LCS(a, b, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(
                    LCS(a, b, n - 1, m, dp),
                    LCS(a, b, n, m - 1, dp)
            );
        }

        return dp[n][m];
    }

    public int longestCommonSubsequence(String a, String b) {

        int n = a.length();
        int m = b.length();

        StringBuilder A= new StringBuilder(a);
        StringBuilder B= new StringBuilder(b);


        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return LCS(A, B, n, m, dp);
    }
}