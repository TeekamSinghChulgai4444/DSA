package LongestCommonSubsequence;
import java.util.*;

public class LCS {   // 1143

    public int lcs(StringBuilder A , StringBuilder B , int n , int m , int [][] dp){

        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(A.charAt(n-1) == B.charAt(m-1)){
            return dp[n][m] = 1 + lcs(A, B, n-1, m-1, dp);
        } else {
            return dp[n][m] = Math.max(
                    lcs(A, B, n-1, m, dp),
                    lcs(A, B, n, m-1, dp)
            );
        }

    }

    public static void main(String[] args) {

        String s="abacde";

        StringBuilder A=new StringBuilder(s);
        String reversed = new StringBuilder(s).reverse().toString();
        StringBuilder B = new  StringBuilder(reversed);

        int n = A.length();
        int m = B.length();

        int [][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        LCS obj = new LCS();

        System.out.println("Answer : " + obj.lcs(A, B, n, m, dp));
    }
}