package ALGORITHM.Dijkastra;

import GRAPH_IMPLIMENTATION.GRAPH;
import GRAPH_IMPLIMENTATION.pair;

import java.util.*;

public class Structure {

    class Node implements Comparable<Node> {
        int node;
        int dist;

        Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return this.dist - other.dist; // min heap
        }
    }

    public int Dijkstra(GRAPH g, int s, int des) {

        int[] dis = new int[g.v];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int node = cur.node;
            int dist = cur.dist;

            // skip outdated entries
            if (dist > dis[node]) continue;

            for (pair p : g.l.get(node)) {
                int nei = p.dest;
                int wt = p.weight;

                if (dis[node] + wt < dis[nei]) {
                    dis[nei] = dis[node] + wt;
                    pq.add(new Node(nei, dis[nei]));
                }
            }
        }

        return dis[des];
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

        Structure obj = new Structure();

        int ans = obj.Dijkstra(g, 1, 5);

        System.out.println("Shortest distance: " + ans);
    }
}