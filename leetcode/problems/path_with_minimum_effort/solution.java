class Solution {

    class Triplate implements Comparable<Triplate> {
        int row;
        int col;
        int effort;

        public Triplate(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        public int compareTo(Triplate p) {
            if (this.effort == p.effort) return this.row - p.row;
            return this.effort - p.effort;
        }
    }

    public int minimumEffortPath(int[][] h) {

        int n = h.length;
        int m = h[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        PriorityQueue<Triplate> pq = new PriorityQueue<>();
        pq.add(new Triplate(0, 0, 0));

        while (pq.size() > 0) {

            Triplate top = pq.remove();

            int row = top.row;
            int col = top.col;
            int effort = top.effort;

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            int ans;

            // down
            if (row + 1 < n) {
                ans = Math.max(effort, Math.abs(h[row + 1][col] - h[row][col]));
                if (ans < dp[row + 1][col]) {
                    dp[row + 1][col] = ans;
                    pq.add(new Triplate(row + 1, col, ans));
                }
            }

            // right
            if (col + 1 < m) {
                ans = Math.max(effort, Math.abs(h[row][col + 1] - h[row][col]));
                if (ans < dp[row][col + 1]) {
                    dp[row][col + 1] = ans;
                    pq.add(new Triplate(row, col + 1, ans));
                }
            }

            // up
            if (row - 1 >= 0) {
                ans = Math.max(effort, Math.abs(h[row - 1][col] - h[row][col]));
                if (ans < dp[row - 1][col]) {
                    dp[row - 1][col] = ans;
                    pq.add(new Triplate(row - 1, col, ans));
                }
            }

            // left
            if (col - 1 >= 0) {
                ans = Math.max(effort, Math.abs(h[row][col - 1] - h[row][col]));
                if (ans < dp[row][col - 1]) {
                    dp[row][col - 1] = ans;
                    pq.add(new Triplate(row, col - 1, ans));
                }
            }
        }

        return 0;
    }
}