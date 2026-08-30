package ALGORITHM.Bellman;

import java.util.*;

public class structure {

    public void bellmanFord() {
        Scanner sc = new Scanner(System.in);

        // number of vertices and edges
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<Triplate> edges = new ArrayList<>();

        // input edges
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Triplate(s, d, w));
        }

        // source node
        int src = sc.nextInt();

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Bellman-Ford relaxation
        for (int i = 0; i < v - 1; i++) {
            for (Triplate edge : edges) {
                if (dist[edge.s] != Integer.MAX_VALUE &&
                        dist[edge.des] > dist[edge.s] + edge.wt) {

                    dist[edge.des] = dist[edge.s] + edge.wt;
                }
            }
        }

        // check negative cycle
        for (Triplate edge : edges) {
            if (dist[edge.s] != Integer.MAX_VALUE &&
                    dist[edge.des] > dist[edge.s] + edge.wt) {

                System.out.println("Negative Cycle Detected");
                return;
            }
        }

        // print result
        for (int i = 0; i < v; i++) {
            System.out.println("Distance from source to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        structure obj = new structure();
        obj.bellmanFord();
    }
}

class Triplate {
    int s;
    int des;
    int wt;

    public Triplate(int s, int d, int w) {
        this.s = s;
        this.des = d;
        this.wt = w;
    }
}