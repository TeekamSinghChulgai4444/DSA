package LEETCODE;
import java.util.*;
public class NextGreaterElement_I {
    public ArrayList<Integer> nextElement(int [] arr){

        int l= arr.length;

        int [] ans= new int[l];

        Stack<Integer>st = new Stack<>();

        Arrays.fill(ans, -1);

        for(int i= l-1 ;i>=0;i--){

            while(st.size()>0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size()>0)
                ans[i]=st.peek();

            st.push(arr[i]);
        }

        ArrayList<Integer>answer =new ArrayList<>();

        for(int j: ans ){
            answer.add(j);

        }
        return answer;

    }
    public static void main(String[] args) {
        

    }
}
