class Solution {
public:
    void check(int i, int j, int n, int m,
               vector<vector<char>>& grid,
               vector<vector<bool>>& board) {

        if (i < 0 || j < 0 || i >= n || j >= m ||
            grid[i][j] != '1' || board[i][j])
            return;

        board[i][j] = true;

        check(i, j + 1, n, m, grid, board);
        check(i, j - 1, n, m, grid, board);
        check(i - 1, j, n, m, grid, board);
        check(i + 1, j, n, m, grid, board);
    }

    int numIslands(vector<vector<char>>& grid) {

        int n = grid.size();
        int m = grid[0].size();

        vector<vector<bool>> board(n, vector<bool>(m, false));
        int island = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j] && grid[i][j] == '1') {
                    island++;
                    check(i, j, n, m, grid, board);
                }
            }
        }
        return island;
    }
};
