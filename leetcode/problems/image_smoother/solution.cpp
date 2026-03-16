class Solution {
public:
   int helper(int i, int j, vector<vector<int>>& img, int& n, int& m) {

    int count = 1;
    int sum = img[i][j];

    if (i - 1 >= 0) {
        count++;
        sum += img[i - 1][j];
    }

    if (i + 1 < m) {
        count++;
        sum += img[i + 1][j];
    }

    if (j - 1 >= 0) {
        count++;
        sum += img[i][j - 1];
    }

    if (j + 1 < n) {
        count++;
        sum += img[i][j + 1];
    }

    if (i - 1 >= 0 && j - 1 >= 0) {
        count++;
        sum += img[i - 1][j - 1];
    }

    if (i - 1 >= 0 && j + 1 < n) {
        count++;
        sum += img[i - 1][j + 1];
    }

    if (i + 1 < m && j - 1 >= 0) {
        count++;
        sum += img[i + 1][j - 1];
    }

    if (i + 1 < m && j + 1 < n) {
        count++;
        sum += img[i + 1][j + 1];
    }

    return sum / count;
}

    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        int m = img.size();
        int n = img[0].size();

        vector<vector<int>> ans(m, vector<int>(n, 0));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = helper(i, j, img, n, m);
            }
        }
        return ans;
    }
};