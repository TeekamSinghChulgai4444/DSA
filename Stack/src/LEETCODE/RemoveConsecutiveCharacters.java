package LEETCODE;
import java.util.*;
public class RemoveConsecutiveCharacters {
    public String removeDuplicates(String s) {
        // code here
        Stack<Character> st = new Stack<>();

        String str="";

        for (char ch : s.toCharArray()) {
            if (st.size() == 0) {
                st.push(ch);
                str+=ch;
                continue;
            }
            if (st.peek() == ch) {
                continue;
            }
            str+=ch;
            st.push(ch);
        }


        return str;
    }
    public static void main(String[] args) {

    }
}
