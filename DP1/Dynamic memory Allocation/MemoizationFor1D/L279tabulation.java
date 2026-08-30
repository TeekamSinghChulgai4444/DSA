package MemoizationFor1D;

public class L279tabulation {

    boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public int tabulation(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            if (isSquare(i)) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;

                for (int j = 1; j * j <= i; j++) {
                    int count = 1 + dp[i - j * j];
                    min = Math.min(min, count);
                }

                dp[i] = min;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        L279tabulation obj = new L279tabulation();
        System.out.println(obj.tabulation(12)); // Output: 3 (4+4+4)
        System.out.println(obj.tabulation(13)); // Output: 2 (4+9)
    }
}