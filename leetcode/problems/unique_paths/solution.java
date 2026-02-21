import java.util.Arrays;

class Solution {

    public int path(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = path(i + 1, j, m, n, dp)
                        + path(i, j + 1, m, n, dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return path(0, 0, m, n, dp);
    }
}