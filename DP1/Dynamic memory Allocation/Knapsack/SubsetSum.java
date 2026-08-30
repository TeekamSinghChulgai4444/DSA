package Knapsack;

import java.util.Arrays;

public class SubsetSum {

    public boolean sum(int[] arr, int i, int target, int[][] dp) {

        if (target == 0) {
            return true;
        }

        if (i >= arr.length) {
            return false;
        }

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean skip = sum(arr, i + 1, target, dp);

        boolean take = false;
        if (arr[i] <= target) {
            take = sum(arr, i + 1, target - arr[i], dp);
        }

        dp[i][target] = (skip || take) ? 1 : 0;
        return dp[i][target] == 1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 6, 5};
        int target = 10;

        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        SubsetSum obj = new SubsetSum();
        System.out.println("Answer: " + obj.sum(arr, 0, target, dp));
    }
}