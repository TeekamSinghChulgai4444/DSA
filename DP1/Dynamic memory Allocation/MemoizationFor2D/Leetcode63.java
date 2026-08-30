package MemoizationFor2D;
import java.util.*;

public class Leetcode63 {

    public int Path(int [][] grid,int row, int col,int r, int c ,int dp[][] ){
        if(row>r || col>c || grid[row][col]==1){
            return 0;
        }
        if(row==r && col == c){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        return dp[row][col]=Path(grid, row+1,col,r,c,dp )+Path(grid, row,col+1,r,c,dp );
    }


    public int uniquePath(int [][] grid){
        int row=0;
        int col=0;
        int r=grid.length-1;
        int c= grid[0].length-1;

        int dp[][]=new int[r+1][c+1];

        for(int i=0;i<=r;i++){
            Arrays.fill(dp[i],-1);
        }

        return Path(grid, row ,col, r ,c,dp);

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        System.out.print("Enter total number of row in grid : ");
        int row = sc.nextInt();

        System.out.print("Enter total number of col in grid : ");
        int col = sc.nextInt();

        int grid[][]=new int[row][col];

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("grid["+i+"]["+j+"] : ");
                int temp = sc.nextInt();
                grid[i][j]=temp;
            }
            System.out.println();
        }

        Leetcode63 obj=new Leetcode63();

        System.out.print("Answer : "+ obj.uniquePath(grid));

    }
}
