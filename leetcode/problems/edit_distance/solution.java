import java.util.Arrays;

class Solution {

    public int mindDst(StringBuilder Abc, StringBuilder Bcd, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            if (n == m) {
                return 0;
            }
            if (m == 0) {
                return n;
            }
            return m;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (Abc.charAt(n - 1) == Bcd.charAt(m - 1)) {
            return dp[n][m] = mindDst(Abc, Bcd, n - 1, m - 1, dp);
        } 
        else {
            int remove = 1 + mindDst(Abc, Bcd, n - 1, m, dp);
            int replace = 1 + mindDst(Abc, Bcd, n - 1, m - 1, dp);
            int insert = 1 + mindDst(Abc, Bcd, n, m - 1, dp);

            return dp[n][m] = Math.min(remove, Math.min(replace, insert));
        }
    }

    public int minDistance(String word1, String word2) {

        StringBuilder Abc = new StringBuilder(word1);
        StringBuilder Bcd = new StringBuilder(word2);

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return mindDst(Abc, Bcd, n, m, dp);
    }
}