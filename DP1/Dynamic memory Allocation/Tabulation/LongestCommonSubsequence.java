package Tabulation;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String txt, String txt1) {

        int n = txt.length();
        int m = txt1.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (txt.charAt(i - 1) == txt1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        for(var rem : dp){
            for(var ab : rem){
                System.out.print(ab+" ");
            }
            System.out.println();
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        String s1 = "abcdeF";
        String s2 = "fbcdeftdr";

        System.out.println(obj.longestCommonSubsequence(s1, s2));

    }
}