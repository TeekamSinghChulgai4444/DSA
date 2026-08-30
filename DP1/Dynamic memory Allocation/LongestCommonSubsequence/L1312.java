package LongestCommonSubsequence;

public class L1312 {

    // minimum insertion steps to make palindromic

    public int minInsertions(StringBuilder s  , int i , int j){
        if(i>=j){
            return 0;
        }
        if(s.charAt(i)==s.charAt(j)){
            return minInsertions(s,i+1,j-1);
        }
        else{
            int left=1+minInsertions(s,i,j-1);
            int right=1+minInsertions(s,i+1,j);
            return Math.min(left,right);
        }
    }

    public static void main(String[] args) {
        String s ="abcdef";
        StringBuilder a= new StringBuilder(s);

        int i=0;
        int n= s.length()-1;
        L1312 obj=new L1312();
        System.out.println("Answer : "+obj.minInsertions(a,i,n) );

    }
}
