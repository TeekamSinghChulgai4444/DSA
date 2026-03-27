class Solution {
    public int check(int st, int s) {
        int ans = 0;
        int row = 0;
        while (st > 0 || s > 0) {

            if (st < row + 1) {
                break;
            }
            if (st >= row + 1) {
                st -= row + 1;
                row++;
            }
            if (s < row) {
                break;
            }

            if (s >= row + 1) {
                s -= row + 1;
                row++;
            }
        }
        return row;
    }

    public int maxHeightOfTriangle(int red, int blue) {

        return Math.max(check(red, blue), check(blue, red));

    }
}