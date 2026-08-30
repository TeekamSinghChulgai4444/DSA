package Unbounded_Knapsack;

// coin change

import java.util.*;

public class Leetcode322 {
    static final int INF = 1000000;
    public int fun(int [] arr, int i,int target, int count ,int [][] dp) {

        if(target == 0){
            return 0;
        }
        if(arr.length <= i){
              return INF;
        }
        if(dp[i][target] != -1){
           return dp[i][target];
        }
        int skip=fun(arr,i+1,target ,count,dp);

        if(arr[i]>target){
            return dp[i][target]=skip;
        }
        int take=1+fun(arr,i,target-arr[i],count+1,dp);

        return dp[i][target]=Math.min(skip,take);

    }

    public static void main(String[] args) {

        int []arr={1,2,5};
        int target=11;

        int [][] dp= new int[arr.length][target+1];

        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }

        Leetcode322 obj=new Leetcode322();

        System.out.println(" Answer  : "+obj.fun(arr,0,target,0,dp));


    }
}
