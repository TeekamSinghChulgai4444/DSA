package IMPLIMENTATION.DIRECTED;

import java.util.*;

public class Structure {

    static class Graph {
        int v;
        List<List<Integer>> adj;

        Graph(int v) {
            this.v = v;
            adj = new ArrayList<>();

            // Initialize adjacency list
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        System.out.println(g.adj);
    }
}