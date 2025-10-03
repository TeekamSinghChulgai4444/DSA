class Solution {
public:
    void sol(vector<int>& arr, const vector<vector<int>>& pre, int& up, int& down, int& right, int& left, int& i, int& j) {
        if (i == up && j == left) {
            while (j <= right) {
                arr.push_back(pre[i][j++]);
            }
            up++;
            i = up;
            j = right;
            return;
        }
        if (i == up && j == right) {
            while (i <= down) {
                arr.push_back(pre[i++][j]);
            }
            right--;
            i = down;
            j = right;
            return;
        }
        if (i == down && j == right) {
            while (j >= left) {
                arr.push_back(pre[i][j--]);
            }
            down--;
            i = down;
            j = left;
            return;
        }
        if (i == down && j == left) {
            while (i >= up) {
                arr.push_back(pre[i--][j]);
            }
            left++;
            i = up;
            j = left;
            return;
        }
    }

    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ans;
        int i = 0, j = 0, up = 0, left = 0;
        int right = matrix[0].size() - 1;
        int down = matrix.size() - 1;

        while (up <= down && left <= right) {
            sol(ans, matrix, up, down, right, left, i, j);  // use ans instead of arr
        }

        return ans;
    }
};
   