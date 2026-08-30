package MemoizationFor1D;
import java.util.*;

public class countDeragement {

    public long count(int n, long[] dp) {

        if (n <= 1) return n;


        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] =  n * count(n - 1, dp);
    }

    public static void main(String[] args) {
        System.out.print("Enter an input number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        countDeragement obj = new countDeragement();

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Answer: " + obj.count(n, dp));
        sc.close();
    }
}