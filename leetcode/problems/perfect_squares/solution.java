class Solution {
    public boolean isperfectSquare(int n) {

        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    public int perfect(int n, int[] dp) {
        if (isperfectSquare(n)) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){
            int count=perfect(i*i,dp)+perfect(n-i*i,dp);
            min=Math.min(min,count);
        }
        return dp[n]=min;
    }

    public int numSquares(int n) {

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return perfect(n,dp);

    }
}