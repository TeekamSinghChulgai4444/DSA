class Solution {
public:
    bool issafe(vector<vector<string>>& board, int row, int n, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == "Q") return false;
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q") return false;
        }
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == "Q") return false;
        }
        return true;
    }

    void solveNQueens(vector<vector<string>>& board, int row, int n, vector<vector<vector<string>>>& results) {
        if (row == n) {
            results.push_back(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (issafe(board, row, n, col)) {
                board[row][col] = "Q";
                solveNQueens(board, row + 1, n, results);
                board[row][col] = ".";
            }
        }
    }

    int totalNQueens(int n) {
        vector<vector<vector<string>>> total;
        vector<vector<string>> board(n, vector<string>(n, "."));
        solveNQueens(board, 0, n, total);
        return total.size();
    }
};