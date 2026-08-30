package Knapsack;

import java.util.Arrays;

public class ThiefMaxProfit {

    public int profit(int[] item, int[] weight, int i, int c,int[][]dp) {

        if (i >= item.length ) {
            return 0;
        }
        if(dp[i][c] != -1){
            return dp[i][c];
        }

        int skip = profit(item, weight, i + 1, c,dp);

        if (weight[i] > c) {
            return dp[i][c]= skip;
        }

        int take = item[i] + profit(item, weight, i + 1, c - weight[i],dp);

        return dp[i][c]=Math.max(take, skip);
    }

    public static void main(String[] args) {

        int[] item = {5, 5, 7, 14};
        int[] weight = {1, 2, 8, 1};
        int c = 11;
       int n=item.length;

       int[][] dp= new int[n][c+1];
       for(int i=0;i<n;i++){
           Arrays.fill(dp[i],-1);
       }

        ThiefMaxProfit obj = new ThiefMaxProfit();
        System.out.println("Answer: " + obj.profit(item, weight, 0, c,dp));

       /*

       for(var i : dp){
            for(var it : i ){
                System.out.print(" "+it+" ");
            }
            System.out.println();
        }

        */
    }
}