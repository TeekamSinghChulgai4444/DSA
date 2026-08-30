package MemoizationFor1D;

import java.util.Arrays;

public class PerfectSquare {
     // 279
    // check if n is a perfect square
    boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public int numSquare(int n, int[] dp) {

        if (isSquare(n)) return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i*i <= n; i++) {
            int count = 1+ numSquare(n - i*i, dp);
            min = Math.min(min, count);
        }

        return dp[n] = min;
    }

    public static void main(String[] args) {

        int n = 10;   // example input

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        PerfectSquare obj = new PerfectSquare();

        System.out.println("Least number of perfect squares: " + obj.numSquare(n, dp));
    }
}