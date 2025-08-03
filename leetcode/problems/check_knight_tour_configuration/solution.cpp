class Solution {
public:
    bool check(vector<vector<int>>& grid, int n, int val, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != val) {
            return false;
        }

        if (val == n * n - 1) {
            return true;
        }

        bool ans1 = check(grid, n, val + 1, row + 2, col - 1);
        bool ans2 = check(grid, n, val + 1, row + 2, col + 1);
        bool ans3 = check(grid, n, val + 1, row - 2, col + 1);
        bool ans4 = check(grid, n, val + 1, row - 2, col - 1);
        bool ans5 = check(grid, n, val + 1, row - 1, col - 2);
        bool ans6 = check(grid, n, val + 1, row + 1, col - 2);
        bool ans7 = check(grid, n, val + 1, row - 1, col + 2);
        bool ans8 = check(grid, n, val + 1, row + 1, col + 2);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    bool checkValidGrid(vector<vector<int>>& grid) {
        int n = grid.size();
        return check(grid, n, 0, 0, 0);
    }
};