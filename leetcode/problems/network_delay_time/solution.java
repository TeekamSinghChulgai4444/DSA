class Solution {

    public class pair implements Comparable<pair> {
        int des;
        int weight;

        public pair(int des, int weight) {
            this.des = des;
            this.weight = weight;
        }

        public int compareTo(pair p) {
            if (this.weight == p.weight)
                return this.des - p.des;
            return this.weight - p.weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<pair>());
        }

        int l = times.length;

        for (int i = 0; i < l; i++) {
            int s = times[i][0], d = times[i][1], w = times[i][2];
            adj.get(s).add(new pair(d, w));
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[k] = 0;

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(k, 0));

        while (pq.size() > 0) {
            pair top = pq.remove();

            int node = top.des;
            int w = top.weight;

            if (w > dis[node])
                continue;

            for (pair p : adj.get(node)) {
                int total = w + p.weight;

                if (total < dis[p.des]) {
                    dis[p.des] = total;
                    pq.add(new pair(p.des, total));
                }
            }
        }

        int ans = -1;

        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if (dis[i] > ans) {
                ans = dis[i];
            }
        }

        return ans;
    }
}