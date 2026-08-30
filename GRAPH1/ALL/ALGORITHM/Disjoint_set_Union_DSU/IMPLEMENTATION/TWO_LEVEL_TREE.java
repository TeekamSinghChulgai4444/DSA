package ALGORITHM.Disjoint_set_Union_DSU.IMPLEMENTATION;

import java.util.*;

// path compression
public class TWO_LEVEL_TREE {
    static int parents[];
    static int size[];

    public int find (int a){
        if(parents[a]==a)
            return a;
        return parents[a]=find(parents[a]);
    }

    public void union (int a , int b){
        int leaderA = find(a);
        int leaderB = find(b);

        if(leaderA == leaderB) return;

        if(size[leaderA] > size[leaderB]){
            parents[leaderB] = leaderA;
            size[leaderA] += size[leaderB];
        }
        else {
            parents[leaderA] = leaderB;
            size[leaderB] += size[leaderA];
        }
    }

    public int ByGroup(int[][] edge){
        int n = edge.length;

        parents = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size,1);

        for(int i=1 ; i<=n ; i++)   // FIX (<=n)
            parents[i]=i;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edge[i][j]==1){
                    union(i+1,j+1);   // keeping your style
                }
            }
        }

        int count =0;

        for(int i=1;i<=n;i++){
            if(find(i)==i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}