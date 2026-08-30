package CYCLE;

import java.util.ArrayList;
import java.util.List;

public class DIRECTED {

    class graph {
        int v;
        List<List<Integer>> l;

        graph(int v) {
            this.v = v;
            l = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                l.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            l.get(u).add(v);
        }

        boolean check(int s, boolean[] dp, boolean[] req) {
            dp[s] = true;
            req[s] = true;

            for (int v : l.get(s)) {
                if (!dp[v]) {
                    if (check(v, dp, req)) {
                        return true;
                    }
                } else {
                    if (req[v]) {
                        return true;
                    }
                }
            }

            req[s] = false;
            return false;
        }

        boolean isCycle() {
            boolean[] dp = new boolean[v];
            boolean[] req = new boolean[v];

            for (int i = 0; i < v; i++) {
                if (!dp[i]) {
                    if (check(i, dp, req)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

        DIRECTED obj = new DIRECTED();
        graph g = obj.new graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // cycle

        System.out.println(g.isCycle()); // true
    }
}