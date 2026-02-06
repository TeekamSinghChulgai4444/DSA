class Solution {
public:
    bool dfs(int node, vector<vector<int>>& adj,
             vector<bool>& vis, vector<bool>& rec) {

        vis[node] = true;
        rec[node] = true;

        for (int neigh : adj[node]) {
            if (!vis[neigh]) {
                if (dfs(neigh, adj, vis, rec))
                    return true;
            } else if (rec[neigh]) {
                return true; 
            }
        }

        rec[node] = false;
        return false;
    }

    bool canFinish(int n, vector<vector<int>>& edges) {

        vector<vector<int>> adj(n);

        // build graph
        for (auto &e : edges) {
            adj[e[1]].push_back(e[0]);
        }

        vector<bool> vis(n, false);
        vector<bool> rec(n, false);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, rec))
                    return false;
            }
        }

        return true;
    }
};
