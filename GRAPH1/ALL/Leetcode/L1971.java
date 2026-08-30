package Leetcode;
import java.util.Scanner;
import java.util.*;

import java.util.ArrayList;

public class L1971 {
    public void bfs( List<List<Integer>>adj , int n , int s,boolean [] vis){

            Queue<Integer>q=new LinkedList<>();
            q.add(s);

            while(q.size()>0){
                int front=q.remove();
                for(int ele : adj.get(front)){
                    if(!vis[ele]){
                        q.add(ele);
                        vis[ele]=true;
                    }
                }
            }

            return;


    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int l= edges.length;

        List<List<Integer>>adj=new ArrayList<>();

        boolean vis[]=new boolean[n];
        Arrays.fill(vis, false);

        for(int i =0;i<n;i++){
            List<Integer>list=new ArrayList<>();
            adj.add(list);
        }

        for(int i=0;i<l;i++){
            int a= edges[i][0];
            int b= edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs(adj,n,source,vis);

        return vis[destination];

    }
    public static void main(String[] args) {

        int [][] edges={{0,1},{4,1},{1,2},{2,3},{7,5},{6,7}};

        int n=8;
        int s=0;
        int d=1;

        L1971 obj=new L1971();

        System.out.println("System : "+ obj.validPath(n,edges,s,d));


    }
}
