package Undirected_Graph;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Arrays;

public class L785 {

    // Bipartite  :  means to  firstly  divide into two  set (A,B)
    // Set A : all edges of set A  does not have  connected any edges of set b
    // Set B : all edges does not have  connected all edges of set b

    // whe we can color each node of graph with either red or blue and adjacent
    // nodes must have diff color

    static boolean ans;

    public void bfs(int i, int [][] adj , int[] vis ){
        
    }

    public boolean isBipartite(int[][] graph){
        int n= graph.length;
        int [] visited=new int[n];
        ans=true;
        Arrays.fill(visited , -1);
        for(int i=0;i<n;i++){
            // 1-> red or 0-> blue
            if(visited[i] == -1 || i==0){
                bfs(i,graph,visited);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
