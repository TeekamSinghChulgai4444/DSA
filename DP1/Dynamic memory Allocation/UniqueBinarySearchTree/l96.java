package UniqueBinarySearchTree;

public class l96 {

    // Catalan Number
    public int numTrees(int n) {
        if(n<=1){
            return 1;
        }
        int [] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        l96 obj= new l96();
        System.out.println("total combination : "+ obj.numTrees(5));

    }
}
