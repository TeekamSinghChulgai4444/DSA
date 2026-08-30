package MemoizationFor2D;

import java.util.Arrays;
import java.util.Scanner;

public class Leetcode62Tabulation {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        Arrays.fill(dp[0], 1);

        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        dp[0][0]=0;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
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
