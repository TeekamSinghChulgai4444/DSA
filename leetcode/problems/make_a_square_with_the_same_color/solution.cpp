class Solution {
public:
    bool helper(vector<vector<char>>& grid, int i, int j, int bc, int k,
                int l) {

        if (i < 0 || j < 0 || j > 2 || i > 2 || k < 0 || l < 0 || k > 2 ||
            l > 2) {
            return false;
        }
        if (grid[i][j] == bc && grid[k][l] == bc) {
            return true;
        } else {
            return false;
        }
    }
    bool canMakeSquare(vector<vector<char>>& grid) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                bool ans1 = helper(grid, i - 1, j, grid[i][j], i, j - 1);
                bool ans2 = helper(grid, i - 1, j, grid[i][j], i, j + 1);
                bool ans3 = helper(grid, i, j - 1, grid[i][j], i + 1, j);
                bool ans4 = helper(grid, i, j + 1, grid[i][j], i + 1, j);

                if (ans1 || ans2 || ans3 || ans4) {
                    return true;
                }
            }
        }
        return false;
    }
};