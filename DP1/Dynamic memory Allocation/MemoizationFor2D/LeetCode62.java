package MemoizationFor2D;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode62 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of row in grid : ");
        int row = sc.nextInt();

        System.out.print("Enter total number of col in grid : ");
        int col = sc.nextInt();

        LeetCode62 obj = new LeetCode62();

        System.out.println("Answer: " + obj.uniquePaths(row, col));
    }
}