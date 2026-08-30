package ALGORITHM.Prims;

import java.util.*;

public class L1584 {

    class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    class Solution {

        public int minCostConnectPoints(int[][] points) {

            int n = points.length;

            boolean[] visited = new boolean[n];
            PriorityQueue<Pair> pq = new PriorityQueue<>();

            pq.add(new Pair(0, 0)); // start from node 0

            int totalCost = 0;

            while (!pq.isEmpty()) {
                Pair curr = pq.poll();

                int node = curr.node;
                int cost = curr.cost;

                if (visited[node]) continue;

                visited[node] = true;
                totalCost += cost;

                // Explore all other nodes
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int dist = Math.abs(points[node][0] - points[i][0]) +
                                Math.abs(points[node][1] - points[i][1]);

                        pq.add(new Pair(i, dist));
                    }
                }
            }

            return totalCost;
        }
    }

    public static void main(String[] args) {
        L1584 outer = new L1584();
        Solution sol = outer.new Solution();

        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        System.out.println(sol.minCostConnectPoints(points));
    }
}