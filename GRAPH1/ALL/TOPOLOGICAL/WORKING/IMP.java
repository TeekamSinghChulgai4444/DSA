package TOPOLOGICAL.WORKING;

import GRAPH_IMPLIMENTATION.GRAPH;
import GRAPH_IMPLIMENTATION.pair;

import java.util.*;

public class IMP {

    void dfs(int node, boolean[] vis, Stack<Integer> st, GRAPH g) {
        vis[node] = true;

        for (pair p : g.l.get(node)) {
            int nei = p.dest;

            if (!vis[nei]) {
                dfs(nei, vis, st, g);
            }
        }

        st.push(node);
    }

    public void topological_sort(GRAPH g) {
        boolean[] vis = new boolean[g.v];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < g.v; i++) {
            if (!vis[i]) {
                dfs(i, vis, st, g);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        IMP obj = new IMP();

        GRAPH g = new GRAPH(6);

        // directed edges
        g.addEdge(5, 2, 1);
        g.addEdge(5, 0, 1);
        g.addEdge(4, 0, 1);
        g.addEdge(4, 1, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);

        obj.topological_sort(g);
    }
}