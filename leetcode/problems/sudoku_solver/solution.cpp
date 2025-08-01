class Solution {
public:
    bool isSafe(vector<vector<char>>& board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val || board[i][col] == val)
                return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == val)
                    return false;
            }
        }
        return true;
    }

    bool solve(vector<vector<char>>& board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solve(board, row + 1, 0);
        if (board[row][col] != '.') return solve(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) 
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    void solveSudoku(vector<vector<char>>& board) {
        solve(board, 0, 0);
    }
};