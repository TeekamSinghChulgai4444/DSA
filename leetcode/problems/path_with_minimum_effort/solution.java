class Solution {
  public class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int effort;

        public Triplet(int r, int c, int d) {
            row = r;
            col = c;
            effort = d;
        }

        @Override
        public int compareTo(Triplet t) {
            if (this.effort == t.effort) {
                return this.row - t.row;
            }
            return this.effort - t.effort;
        }
    }

    public int minimumEffortPath(int[][] h) {

        int n = h.length;
        int m = h[0].length;

        int[][] effort = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(0, 0, 0));
        effort[0][0] = 0;

        while (pq.size() > 0) {

            Triplet top = pq.remove();
            int r = top.row, c = top.col, ef = top.effort;

            // up
            if (r >= 1) {
                int temp = Math.abs(h[r][c] - h[r - 1][c]); // FIX
                int newEffort = Math.max(ef, temp); // FIX

                if (newEffort < effort[r - 1][c]) { // FIX
                    effort[r - 1][c] = newEffort; // FIX
                    pq.add(new Triplet(r - 1, c, newEffort));
                }
            }

            // down
            if (r < n - 1) {
                int temp = Math.abs(h[r + 1][c] - h[r][c]); 
                int newEffort = Math.max(ef, temp); 

                if (newEffort < effort[r + 1][c]) {
                    effort[r + 1][c] = newEffort;
                    pq.add(new Triplet(r + 1, c, newEffort));
                }
            }

            // left
            if (c >= 1) {
                int temp = Math.abs(h[r][c] - h[r][c - 1]); 
                int newEffort = Math.max(ef, temp); 

                if (newEffort < effort[r][c - 1]) {
                    effort[r][c - 1] = newEffort;
                    pq.add(new Triplet(r, c - 1, newEffort));
                }
            }

            // right
            if (c < m - 1) { 
                int temp = Math.abs(h[r][c + 1] - h[r][c]);
                int newEffort = Math.max(ef, temp); 

                if (newEffort < effort[r][c + 1]) {
                    effort[r][c + 1] = newEffort;
                    pq.add(new Triplet(r, c + 1, newEffort));
                }
            }
        }

        return effort[n - 1][m - 1];
    }
}