package ALGORITHM.Kruskal;

import GRAPH_IMPLIMENTATION.*;
import java.util.*;

public class minimum_Spanning_Tree {

    static int[] parents;
    static int[] size;

    class Tupple implements Comparable<Tupple> {
        int u, v, w;

        public Tupple(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Tupple other){
            return Integer.compare(this.w, other.w);
        }
    }

    // FIND with path compression
    public int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    // UNION by size
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;

        if(size[pa] > size[pb]){
            parents[pb] = pa;
            size[pa] += size[pb];
        } else {
            parents[pa] = pb;
            size[pb] += size[pa];
        }
    }

    public int kruskal(GRAPH g){
        int n = g.v;

        parents = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);

        for(int i = 0; i < n; i++)
            parents[i] = i;

        PriorityQueue<Tupple> pq = new PriorityQueue<>();

        // add edges (avoid duplicates)
        for(int i = 0; i < n; i++){
            for(pair a : g.l.get(i))
                    pq.add(new Tupple(i, a.dest, a.weight));
        }

        int mstWeight = 0;
        int edgesUsed = 0;

        while(!pq.isEmpty() && edgesUsed < n - 1){
            Tupple e = pq.poll();

            if(find(e.u) != find(e.v)){
                union(e.u, e.v);
                mstWeight += e.w;
                edgesUsed++;
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        minimum_Spanning_Tree obj = new minimum_Spanning_Tree();

        GRAPH g = new GRAPH(7);

        // SAME AS VIDEO GRAPH
        g.addEdgeEdge(0,2,9);
        g.addEdgeEdge(0,6,29);
        g.addEdgeEdge(2,3,26);
        g.addEdgeEdge(3,1,24);
        g.addEdgeEdge(3,5,21);
        g.addEdgeEdge(5,4,11);
        g.addEdgeEdge(4,6,15);
        g.addEdgeEdge(6,1,14);
        g.addEdgeEdge(1,5,19);

        int ans = obj.kruskal(g);

        System.out.println("MST Weight: " + ans);
    }
}