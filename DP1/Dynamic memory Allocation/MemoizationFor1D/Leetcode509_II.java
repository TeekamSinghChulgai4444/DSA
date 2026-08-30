package MemoizationFor1D;

import java.util.Arrays;

public class Leetcode509_II {

    static int[] dp;

    public static int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    private static int solve(int n) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1) + solve(n - 2);
        return dp[n];
    }

    // Optional main for testing
    public static void main(String[] args) {
        System.out.println(fib(2));   // 1
        System.out.println(fib(5));   // 5
        System.out.println(fib(10));  // 55
    }
}