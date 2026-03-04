import java.util.Arrays;

class Solution {

    public int Answer(StringBuilder word1, StringBuilder word2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            if (n == 0 && m == 0) return 0;
            if (n == 0) return m;
            else return n;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return dp[n][m] = Answer(word1, word2, n - 1, m - 1, dp);
        } 
        else {
            return dp[n][m] = 1 + Math.min(
                    Answer(word1, word2, n - 1, m , dp),
                    Answer(word1, word2, n, m - 1, dp)
            );
        }
    }

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringBuilder abc = new StringBuilder(word1);
        StringBuilder bcd = new StringBuilder(word2);

        return Answer(abc, bcd, n, m, dp);
    }
}