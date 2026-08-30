public class LeetCode12 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        int maxProfit = 0;
        for (int k = 0; k < n; k++) {
            maxProfit = Math.max(maxProfit, left[k] + right[k]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        LeetCode12 solver = new LeetCode12();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Max Profit: " + solver.maxProfit(prices));
    }
}