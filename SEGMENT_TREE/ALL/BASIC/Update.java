package BASIC;

import java.util.Arrays;

public class Update {
    public static void update(int i , int j ,int[]ans,int k , int t,int val){
        if(i==j){
            ans[i]=val;
            return;
        }
        int mid=(i+j)/2;

        if(mid>=t){
             update(i,mid-1,ans,k,t,val);
        }else{
            update(mid+1,j,ans,k,t,val);
        }
        ans[i]=ans[2*i+1]+ans[2*i+2];
        return ;
    }
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
        int[] ans=new int[4*n];

        Arrays.fill(ans,-1);

        int k=0;

        imp(0,n-1,arr,ans,k);

        
        update(0,n-1,ans,0,1,13);

        for(int num : ans){
            System.out.print(num + " ");
        }


    }
}
