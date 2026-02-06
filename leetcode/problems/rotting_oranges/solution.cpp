class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {

        int n = grid.size();
        int m = grid[0].size();

        vector<vector<bool>> check(n, vector<bool>(m, false));
        queue<pair<int, pair<int, int>>> q;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.push({0, {i, j}});
                    check[i][j] = true;
                }
            }
        }

        int exact = 0;

        while (!q.empty()) {
            int time = q.front().first;
            int i = q.front().second.first;
            int j = q.front().second.second;
            q.pop();

            exact = max(exact, time);

            if (i - 1 >= 0 && !check[i - 1][j] && grid[i - 1][j] == 1) {
                check[i - 1][j] = true;
                q.push({time + 1, {i - 1, j}});
            }

            if (i + 1 < n && !check[i + 1][j] && grid[i + 1][j] == 1) {
                check[i + 1][j] = true;
                q.push({time + 1, {i + 1, j}});
            }

            if (j - 1 >= 0 && !check[i][j - 1] && grid[i][j - 1] == 1) {
                check[i][j - 1] = true;
                q.push({time + 1, {i, j - 1}});
            }

            if (j + 1 < m && !check[i][j + 1] && grid[i][j + 1] == 1) {
                check[i][j + 1] = true;
                q.push({time + 1, {i, j + 1}});
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !check[i][j]){
                    return -1;
                }
            }
        }

        return exact;
    }
};
