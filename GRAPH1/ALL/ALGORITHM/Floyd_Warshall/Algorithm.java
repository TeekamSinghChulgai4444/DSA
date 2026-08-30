package ALGORITHM.Floyd_Warshall;

import java.util.*;

public class Algorithm {

    static final int INF = (int)1e9; // represent infinity

    public static void floydWarshall(int[][] graph, int n) {

        int[][] dist = new int[n][n];

        // Step 1: copy graph into dist matrix

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Step 2: main algorithm
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] != INF && dist[via][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],
                                dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        // Step 3: print result
        System.out.println("Shortest Distance Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] graph = {
                {0,   3,   INF, 5},
                {2,   0,   INF, 4},
                {INF, 1,   0,   INF},
                {INF, INF, 2,   0}
        };

        floydWarshall(graph, n);
    }
}