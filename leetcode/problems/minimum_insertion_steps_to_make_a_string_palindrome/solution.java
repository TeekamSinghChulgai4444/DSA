import java.util.Arrays;

class Solution {

    public int Insertions(String s, int i, int j, int[][] dp) {

        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = Insertions(s, i + 1, j - 1, dp);
        } else {
            int left = 1 + Insertions(s, i, j - 1, dp);
            int right = 1 + Insertions(s, i + 1, j, dp);
            dp[i][j] = Math.min(left, right);
        }

        return dp[i][j];
    }

    public int minInsertions(String s) {

        int l = s.length();
        int[][] dp = new int[l][l];

        for (int i = 0; i < l; i++) {
            Arrays.fill(dp[i], -1);
        }

        return Insertions(s, 0, l - 1, dp);
    }
}