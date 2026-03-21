class Solution {

    public String LCS(StringBuilder a, StringBuilder b, int i, int j, String[][] dp) {

        if (i == 0 || j == 0) {
            return "";
        }

        if (!dp[i][j].equals("#")) {
            return dp[i][j];
        }

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return dp[i][j] = LCS(a, b, i - 1, j - 1, dp) + a.charAt(i - 1);
        }

        String left = LCS(a, b, i - 1, j, dp);
        String right = LCS(a, b, i, j - 1, dp);

        if (left.length() > right.length()) {
            return dp[i][j] = left;
        } else {
            return dp[i][j] = right;
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {

        StringBuilder a = new StringBuilder(str1);
        StringBuilder b = new StringBuilder(str2);

        int n = str1.length();
        int m = str2.length();

        String[][] dp = new String[n + 1][m + 1];

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= m; y++) {
                dp[x][y] = "#";
            }
        }

     
        String lcs = LCS(a, b, n, m, dp);

       
        int i = 0, j = 0;
        String ans = "";

        for (char c : lcs.toCharArray()) {

            while (a.charAt(i) != c) {
                ans += a.charAt(i++);
            }

            while (b.charAt(j) != c) {
                ans += b.charAt(j++);
            }

            ans += c;
            i++;
            j++;
        }

        
        while (i < n) ans += a.charAt(i++);
        while (j < m) ans += b.charAt(j++);

        return ans;
    }
}