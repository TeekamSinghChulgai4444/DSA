package Unbounded_Knapsack;

import java.util.Arrays;

public class ThiefMaxProfit {

    public int profit(int[] value, int[] weight, int i, int c, int[][] dp) {

        if (i >= value.length ) {
            return 0;
        }

        if (dp[i][c] != -1) {
            return dp[i][c];
        }

        int skip = profit(value, weight, i + 1, c, dp);

        int take = 0;
        if (weight[i] <= c) {
            take = value[i] + profit(value, weight, i, c - weight[i], dp);
        }

        dp[i][c] = Math.max(skip, take);
        return dp[i][c];
    }

    public static void main(String[] args) {

        int[] value = {15, 14, 10, 45, 30};
        int[] weight = {2, 5, 1, 3, 4};
        int capacity = 7;

        int[][] dp = new int[value.length][capacity + 1];
        for (int i = 0; i < value.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        ThiefMaxProfit obj = new ThiefMaxProfit();
        System.out.println(obj.profit(value, weight, 0, capacity, dp));

        System.out.println("what is going  to inside the array ");
        for(var j: dp){
            for(var a:j){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}