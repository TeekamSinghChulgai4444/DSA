import java.util.*;

public class Solution {

    // BFS traversal
    public void bfs(List<List<Integer>> adj, int source, boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;   

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : adj.get(node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];

        bfs(adj, source, vis);

        return vis[destination];
    }
}