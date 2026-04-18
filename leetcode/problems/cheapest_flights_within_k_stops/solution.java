import java.util.*;

class Solution {

    class Pair {
        int des;
        int weight;

        Pair(int d, int w) {
            des = d;
            weight = w;
        }
    }

    class Triplate implements Comparable<Triplate> {
        int node;
        int cost;
        int stops;

        Triplate(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        public int compareTo(Triplate t) {
            return this.cost - t.cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : flights) {
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }

        PriorityQueue<Triplate> pq = new PriorityQueue<>();
        pq.offer(new Triplate(src, 0, 0));

        int[] stopsArr = new int[n];
        Arrays.fill(stopsArr, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Triplate cur = pq.poll();

            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;

            if (node == dst) return cost;

            if (stops > k) continue;

            if (stopsArr[node] <= stops) continue;

            stopsArr[node] = stops;

            for (Pair p : adj.get(node)) {
                pq.offer(new Triplate(p.des, cost + p.weight, stops + 1));
            }
        }

        return -1;
    }
}