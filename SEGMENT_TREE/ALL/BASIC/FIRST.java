package BASIC;

import java.util.Arrays;

public class FIRST {
    public static int imp(int i,int j,int[] arr,int[] ans ,int k){
        if(i==j){
            ans[k]=arr[i];
            return arr[i];
        }
        int mid=(i+j)/2;

        int left=imp(i,mid,arr,ans,2*k+1);
        int right=imp(mid+1,j,arr,ans,2*k+2);

        return ans[k]=left+right;

    }
    public static void main(String[] args) {
        int [] arr={3,1,2,7};
        int n= arr.length;
        int[] ans=new int[2*n];

        Arrays.fill(ans,-1);

        int k=0;

        imp(0,n-1,arr,ans,k);

        for(int num : ans){
            System.out.print(num + " ");
        }

    }
}
