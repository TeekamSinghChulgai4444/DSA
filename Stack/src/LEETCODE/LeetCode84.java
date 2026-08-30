package LEETCODE;

import java.util.Stack;

public class LeetCode84 {
    public int[] LeftNearestLowest(int[] arr ,int n){
        int [] ans= new int[n];
        
        Stack<Integer>st= new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.size()>1 &&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.peek();
            st.push(i);
        }
        return ans;
        
    }
    public int [] RightNearestLowest(int [] arr ,int n){
        int [] ans= new int[n];

        Stack<Integer>st= new Stack<>();
        st.push(n);
        for(int i=n-1;i>=0;i--){
            while(st.size()>1 &&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] arr) {
        int n= arr.length;
        int [] left=new int[n];
        int [] right = new int [n];
        
        left=LeftNearestLowest(arr,n);
        right=RightNearestLowest(arr,n);

        int smallest=Integer.MIN_VALUE;

        for(int i =0;i<n;i++){
            int temp=(right[i]-left[i]-1)*arr[i];
            smallest=Math.max(smallest,temp);

        }
        return smallest;

    }

    public static void main(String[] args) {
        int [] arr={2,1,5,6,2,3};

        LeetCode84 obj= new LeetCode84();

        int answer= obj.largestRectangleArea(arr);

        System.out.println(answer);

    }
}
