package MemoizationFor1D;
import java.util.Arrays;
import java.util.Scanner;

public class friendPair {

    public static long pair(int n, long[] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = pair(n - 1, dp) + (n - 1) * pair(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Answer : " + pair(n, dp));
    }
}