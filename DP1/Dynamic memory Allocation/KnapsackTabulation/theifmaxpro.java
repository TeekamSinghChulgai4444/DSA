package KnapsackTabulation;

public class theifmaxpro {
    public static void main(String[] args) {

        int[] item = {5, 5, 7, 14};
        int[] weight = {1, 2, 8, 1};
        int c = 11;
        int n = item.length;

        int[][] dp = new int[n][c + 1];

        // Base case: first item
        for (int j = 0; j <= c; j++) {
            if (weight[0] <= j) {
                dp[0][j] = item[0];
            }
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {

                int skip = dp[i - 1][j];

                int take = 0;
                if (weight[i] <= j) {
                    take = item[i] + dp[i - 1][j - weight[i]];
                }

                dp[i][j] = Math.max(take, skip);
            }
        }

        System.out.println("Max Profit: " + dp[n - 1][c]);
    }
}
