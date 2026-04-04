class Solution {

    public class pair {
        int node;
        double weight;

        public pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int s, int t) {

        List<List<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<pair>());
        }

        int l = edges.length;

        for (int i = 0; i < l; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w)); // undirected
        }

        double[] dis = new double[n];
        Arrays.fill(dis, 0.0);

        dis[s] = 1.0;

        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.weight, a.weight) // max heap
        );

        pq.add(new pair(s, 1.0));

        while (pq.size() > 0) {
            pair top = pq.remove();

            int node = top.node;
            double w = top.weight;

            if (w < dis[node]) continue;

            for (pair p : adj.get(node)) {
                double total = w * p.weight;

                if (dis[p.node] < total) {
                    dis[p.node] = total;
                    pq.add(new pair(p.node, total));
                }
            }
        }

        return dis[t];
    }
}