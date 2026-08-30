package LEETCODE;

import java.util.Stack;

public class LeetCode85 {
    public int [][] ConvertInData(char[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] board=new int[n][m];

        for(int i=0;i<m;i++){
            int abc=0;
            for(int j=0;j<n;j++){
                int a=(matrix[j][i]=='1')?1:0;
                abc=(abc+a)*a;
                board[j][i]=abc;
            }
        }
        return board;
    }
    public int[] LeftNearestLowest(int[] arr ,int n){
        int [] ans= new int[n];

        Stack<Integer> st= new Stack<>();
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
    public int maximalRectangle(char[][] matrix) {

        int [][] board=ConvertInData(matrix);

        int largest=Integer.MIN_VALUE;

        for(int[] abc : board){
            int ans=largestRectangleArea(abc);
            largest=Math.max(ans,largest);
        }

        return largest;

    }

    public static void main(String[] args) {
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };

        LeetCode85 obj=new LeetCode85();
        int ans=obj.maximalRectangle(matrix);

        System.out.println("Area of maximal Rectangle is  :" + ans);
    }
}
