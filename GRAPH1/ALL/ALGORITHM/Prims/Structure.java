package ALGORITHM.Prims;

import GRAPH_IMPLIMENTATION.GRAPH;
import GRAPH_IMPLIMENTATION.pair;

import java.util.*;

public class Structure {

    class Triplate implements Comparable<Triplate> {
        int source;
        int parents;
        int weight;

        public Triplate(int s, int w, int p) {
            this.source = s;
            this.parents = p;
            this.weight = w;
        }

        @Override
        public int compareTo(Triplate p) {
            return this.weight - p.weight;
        }
    }

    public void Algorithm(GRAPH g) {

        int n = g.v;

        boolean[] vis = new boolean[n];
        PriorityQueue<Triplate> pq = new PriorityQueue<>();

        int sum = 0;

        // (node, weight, parent)
        pq.add(new Triplate(0, 0, -1));

        ArrayList<Triplate> mst = new ArrayList<>();

        while (!pq.isEmpty()) {

            Triplate top = pq.poll();
            int node = top.source;

            if (vis[node]) continue;

            vis[node] = true;
            sum += top.weight;

            // skip dummy edge
            if (top.parents != -1) {
                mst.add(top);
            }

            for (pair nbr : g.l.get(node)) {
                if (!vis[nbr.dest]) {
                    pq.add(new Triplate(nbr.dest, nbr.weight, node));
                }
            }
        }

        // Print MST edges
        System.out.println("MST Edges:");
        for (Triplate t : mst) {
            System.out.println(t.parents + " -> " + t.source + " weight: " + t.weight);
        }

        System.out.println("MST Weight: " + sum);
    }

    public static void main(String[] args) {

        GRAPH g = new GRAPH(5);

        g.addEdgeEdge(0, 1, 2);
        g.addEdgeEdge(0, 4, 1);
        g.addEdgeEdge(0, 2, 5);
        g.addEdgeEdge(1, 4, 3);
        g.addEdgeEdge(2, 4, 2);
        g.addEdgeEdge(4, 3, 3);
        g.addEdgeEdge(1, 3, 1);
        g.addEdgeEdge(3, 2, 5);

        Structure obj = new Structure();
        obj.Algorithm(g);
    }
}