package TOPOLOGICAL.KHANS_ALGORITHM;

import GRAPH_IMPLIMENTATION.*;

import java.util.*;

public class KHANS {

    // Step 1: Calculate indegree
    public void findIndegree(int[] indegree, GRAPH g) {
        for (int i = 0; i < g.v; i++) {
            for (pair p : g.l.get(i)) {
                indegree[p.dest]++;
            }
        }
    }

    // Step 2: Kahn’s Algorithm
    public void topo(GRAPH g) {
        int[] indegree = new int[g.v];
        findIndegree(indegree, g);

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        // push nodes with indegree 0
        for (int i = 0; i < g.v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            count++;

            for (pair p : g.l.get(node)) {
                int nei = p.dest;
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        // ✅ Cycle check
        if (count != g.v) {
            System.out.println("Cycle exists, Topological Sort not possible");
            return;
        }

        // ✅ Print result nicely
        System.out.println("Topological Order:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        GRAPH g = new GRAPH(7);

        g.addEdge(1, 2, 4);
        g.addEdge(2, 3, 5);
        g.addEdge(2, 4, 6);
        g.addEdge(1, 3, 7);
        g.addEdge(4, 5, 8);
        g.addEdge(4, 6, 9);
        g.addEdge(3, 5, 10);

        KHANS obj = new KHANS();
        obj.topo(g);
    }
}