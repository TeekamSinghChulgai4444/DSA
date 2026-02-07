class Solution {
public:
    bool topology(int s, vector<vector<int>>& edge, vector<bool>& req,
                  vector<bool>& vis, vector<int>& temp) {

        vis[s] = true;
        req[s] = true;

        for (int i = 0; i < edge.size(); i++) {

            int u = edge[i][1]; // u -> v
            int v = edge[i][0];

            if (s == u) {
                if (!vis[v]) {
                    if (topology(v, edge, req, vis, temp))
                        return true;
                } else if (req[v]) {
                    return true; // cycle detected
                }
            }
        }

        req[s] = false;
        temp.push_back(s);
        return false;
    }

    vector<int> findOrder(int n, vector<vector<int>>& edge) {
        vector<bool> vis(n, false);
        vector<bool> req(n, false);
        vector<int> temp;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (topology(i, edge, req, vis, temp))
                    return {};
            }
        }

        reverse(temp.begin(), temp.end());
        return temp;
    }
};