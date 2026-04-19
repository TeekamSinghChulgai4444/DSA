class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] check = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(check[i], Integer.MAX_VALUE);
        }
        int[][] ans = new int[n][m];
        PriorityQueue<Triplate> pq = new PriorityQueue<>();
        int row = sources.length;
        for(int i = 0; i < row; i++){
            int[] temp = sources[i];
            int r1 = temp[0];
            int c1 = temp[1];
            int col = temp[2];
            check[r1][c1] = 0;
            ans[r1][c1] = col;
            pq.offer(new Triplate(r1, c1, col, 0));
        }
        while(pq.size() > 0){
            Triplate t = pq.poll();
            int rr = t.row;
            int cc = t.col;
            int clr = t.color;
            int st = t.steps;
            // up
            if(rr - 1 >= 0){
                if(check[rr-1][cc] > st + 1){
                    check[rr-1][cc] = st + 1;
                    ans[rr-1][cc] = clr;
                    pq.offer(new Triplate(rr-1, cc, clr, st+1));
                } else if(check[rr-1][cc] == st + 1 && clr > ans[rr-1][cc]){
                    ans[rr-1][cc] = clr;
                    pq.offer(new Triplate(rr-1, cc, clr, st+1));
                }
            }
            // down
            if(rr + 1 < n){
                if(check[rr+1][cc] > st + 1){
                    check[rr+1][cc] = st + 1;
                    ans[rr+1][cc] = clr;
                    pq.offer(new Triplate(rr+1, cc, clr, st+1));
                } else if(check[rr+1][cc] == st + 1 && clr > ans[rr+1][cc]){
                    ans[rr+1][cc] = clr;
                    pq.offer(new Triplate(rr+1, cc, clr, st+1));
                }
            }
            // left
            if(cc - 1 >= 0){
                if(check[rr][cc-1] > st + 1){
                    check[rr][cc-1] = st + 1;
                    ans[rr][cc-1] = clr;
                    pq.offer(new Triplate(rr, cc-1, clr, st+1));
                } else if(check[rr][cc-1] == st + 1 && clr > ans[rr][cc-1]){
                    ans[rr][cc-1] = clr;
                    pq.offer(new Triplate(rr, cc-1, clr, st+1));
                }
            }
            // right
            if(cc + 1 < m){
                if(check[rr][cc+1] > st + 1){
                    check[rr][cc+1] = st + 1;
                    ans[rr][cc+1] = clr;
                    pq.offer(new Triplate(rr, cc+1, clr, st+1));
                } else if(check[rr][cc+1] == st + 1 && clr > ans[rr][cc+1]){
                    ans[rr][cc+1] = clr;
                    pq.offer(new Triplate(rr, cc+1, clr, st+1));
                }
            }
        }
        return ans;
    }
}

public class Triplate implements Comparable<Triplate>
{
    int row;
    int col;
    int color;
    int steps;
    public Triplate(int row, int col, int color, int steps) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.steps = steps;
    }
    public int compareTo(Triplate other) {
        return this.steps - other.steps;
    }
}