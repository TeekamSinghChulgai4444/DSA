class Solution {
public:
    void fun(vector<vector<int>>& image, int i, int j,
             int color, int oldColor, int n, int m) {

        if (i < 0 || j < 0 || i >= n || j >= m)
            return;

        if (image[i][j] != oldColor)
            return;

        image[i][j] = color;

        fun(image, i + 1, j, color, oldColor, n, m);
        fun(image, i - 1, j, color, oldColor, n, m);
        fun(image, i, j + 1, color, oldColor, n, m);
        fun(image, i, j - 1, color, oldColor, n, m);
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image,
                                  int sr, int sc, int color) {

        int n = image.size();
        int m = image[0].size();

        int oldColor = image[sr][sc];

        if (oldColor == color)
            return image;

        fun(image, sr, sc, color, oldColor, n, m);
        return image;
    }
};
