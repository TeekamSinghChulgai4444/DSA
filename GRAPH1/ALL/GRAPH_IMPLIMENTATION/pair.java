package GRAPH_IMPLIMENTATION;

import ALGORITHM.Dijkastra.Structure;

public class pair implements Comparable<pair> {
    public int dest;
    public int weight;

    public pair(int dist, int weight) {
        this.dest = dist;
        this.weight = weight;
    }

    @Override
    public int compareTo(pair other) {
        return this.dest - other.dest; // min heap
    }
}