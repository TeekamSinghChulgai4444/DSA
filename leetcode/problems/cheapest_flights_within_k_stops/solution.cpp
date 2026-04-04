class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int,int>>> adj(n);
        
        for(auto it : flights){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            adj[u].push_back({v,w});
        }
        
        queue<pair<int, pair<int,int>>> q;
        
        q.push({0, {src, 0}});
        
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            
            int stops = it.first;
            int node = it.second.first;
            int cost = it.second.second;
            
            if(stops > k) continue;
            
            for(auto p : adj[node]){
                int nei = p.first;
                int wt = p.second;
                
                if(cost + wt < dist[nei] && stops <= k){
                    dist[nei] = cost + wt;
                    q.push({stops + 1, {nei, dist[nei]}});
                }
            }
        }
        
        if(dist[dst] == INT_MAX) return -1;
        return dist[dst];
    }
};