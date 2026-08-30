package MemoizationFor2D;

public class LeetCode64 {

    public int Path(int grid[][],int dp[][],int i ,int j,int m ,int n){

        if(i>m || j>n){
            return 10000;
        }
        if(i==m && j==n){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        return dp[i][j]=grid[i][j]+Math.min(Path(grid,dp,i+1,j,m,n),Path(grid,dp,i,j+1,m,n));
    }

    public int minPathSum(int grid[][]){

        int m=grid.length-1;
        int n=grid[0].length-1;

        int dp[][]=grid;

        return Path(grid,dp,0,0,m,n);
    }

    public static void main(String[] args) {

        int grid[][]= {{1, 3, 1},
                {1, 5, 9},
                {4, 2, 1}
        };

        LeetCode64 obj=new LeetCode64();
        System.out.println("Answer: " + obj.minPathSum(grid));

    }
}
