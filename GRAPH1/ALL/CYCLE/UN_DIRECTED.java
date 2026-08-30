package CYCLE;

import java.util.*;

public class UN_DIRECTED {

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
            l.get(v).add(u);
        }

        boolean check(int s, boolean[] dp, int parent) {
            dp[s] = true;

            for (int v : l.get(s)) {
                if (!dp[v]) {
                    if (check(v, dp, s)) {
                        return true;
                    }
                } else {
                    if (v != parent) {
                        return true;
                    }

                }
            }
            return false;
        }

        boolean isCycle() {
            boolean[] dp = new boolean[v];

            for (int i = 0; i < v; i++) {
                if (!dp[i]) {
                    if (check(i, dp, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

        UN_DIRECTED obj = new UN_DIRECTED();
        graph g = obj.new graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // cycle

        System.out.println(g.isCycle()); // true
    }
}