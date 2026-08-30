package LEETCODE;

import java.util.*;

public class stockSpanProblem {

        public  ArrayList<Integer> calculateSpan(int[] arr){
            ArrayList<Integer>ans= new ArrayList<>();
            Stack<Integer>st = new Stack<>();
            st.push(-1);
            int l= arr.length;

            for(int j = 0;j<l;j++){
                while(st.size()>1 && arr[st.peek()]<=arr[j]){
                    st.pop();
                }
                ans.add(j-st.peek());
                st.push(j);
            }
            st.clear();

            return ans;
        }


    public static void main(String[] args) {
        stockSpanProblem obj1= new stockSpanProblem();
        int [] arr={100,80,60,70,60,75,85,123,567,4,67,900};
        ArrayList<Integer>ans= obj1.calculateSpan(arr);

        for(var m : ans){
            System.out.print(m+" ");
        }
    }
}
