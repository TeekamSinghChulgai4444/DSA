class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        int l = 0, m = 0;

        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = k;

            while (j < n) {

                if (i == j) {
                    dp[i][j] = 1;
                } else if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                        l = i;
                        m = j;

                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        l = i;
                        m = j;
                    }
                }

                i++;
                j++;
            }
        }

        return s.substring(l, m + 1);
    }

}