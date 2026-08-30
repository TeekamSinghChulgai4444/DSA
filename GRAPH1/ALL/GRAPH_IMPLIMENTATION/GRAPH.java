package GRAPH_IMPLIMENTATION;

import java.util.*;;

public class GRAPH {
    public int v;
    public List<List<pair>> l;

    public GRAPH (int v){
        this.v=v;
        l=new ArrayList<>();

        for (int i = 0; i < v; i++) {
            l.add(new ArrayList<>());
        }

    }

    public void addEdge(int s , int des, int w){
        l.get(s).add(new pair(des,w));
    }
    public void addEdgeEdge(int s, int des ,int w){
        l.get(s).add(new pair(des,w));
        l.get(des).add(new pair(s,w));
    }
}
