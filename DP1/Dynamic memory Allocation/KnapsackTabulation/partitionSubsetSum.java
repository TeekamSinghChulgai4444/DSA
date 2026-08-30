package KnapsackTabulation;

import java.util.Arrays;

public class partitionSubsetSum {


    public boolean target(int[] arr,int i , int tar ,int [][] dp){
        if(i==arr.length){
            if(tar==0){
                return true;
            }
            else
                return false;
        }
        if(dp[i][tar] != -1){
            return dp[i][tar] == 1;
        }
        boolean skip=target(arr,i+1,tar,dp);
        boolean pick=false;
        if(tar>=arr[i]){
            pick=target(arr,i+1,tar-arr[i] ,dp);
        }
       dp[i][tar] = (pick || skip ) ? 1 :0;

        return dp[i][tar]==1;
    }

    public static void main(String[] args) {

        int [] arr={1,2,4,5,6,7};
        int tar=13;

        int n=arr.length;


        int[][] dp = new int[n][tar+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        partitionSubsetSum obj= new partitionSubsetSum();

        System.out.println("Answer : "+ obj.target(arr,0,tar,dp));




    }
}
