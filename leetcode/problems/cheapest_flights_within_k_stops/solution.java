import java.util.*;

public class Solution {

    public class pair {
        int to, cost;

        public pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public class tuple implements Comparable<tuple> {
        int node, cost, stops;

        public tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        public int compareTo(tuple t) {
            return this.cost - t.cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] f : flights) {
            graph.get(f[0]).add(new pair(f[1], f[2]));
        }

        PriorityQueue<tuple> pq = new PriorityQueue<>();
        pq.offer(new tuple(src, 0, 0));

        int[] stopsArr = new int[n];
        Arrays.fill(stopsArr, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            tuple cur = pq.poll();

            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;

            if (node == dst) return cost;

            if (stops > k) continue;

            if (stopsArr[node] <= stops) continue;

            stopsArr[node] = stops;

            for (pair p : graph.get(node)) {
                pq.add(new tuple(p.to, cost + p.cost, stops + 1));
            }
        }

        return -1;
    }
}