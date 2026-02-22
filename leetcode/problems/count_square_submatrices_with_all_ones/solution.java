class Solution {
    public int countSquares(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 1 + Math.min(
                        grid[i - 1][j],
                        Math.min(grid[i - 1][j - 1], grid[i][j - 1])
                    );
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += grid[i][j];
            }
        }

        return sum;
    }
}