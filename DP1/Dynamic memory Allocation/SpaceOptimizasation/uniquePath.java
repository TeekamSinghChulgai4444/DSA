package SpaceOptimizasation;

import java.util.*;

public class uniquePath {
    public int path(int r,int col){
        int grid[][]=new int[2][col];
        Arrays.fill(grid[0],1);
        grid[1][0]=1;
        for(int i=1;i<r;i++){
            for(int j=1;j<col;j++){
                grid[1][j]=grid[0][j]+grid[1][j-1];
            }
            grid[0]=grid[1];
        }
        return grid[1][col-1];
    }
    public static void main(String[] args) {

        uniquePath obj=new uniquePath();
        System.out.println("Answer: " + obj.path(5,6));

    }
}
