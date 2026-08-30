package ALGORITHM.Floyd_Warshall;

import java.util.*;

public class L1334 {
    class Solution {
        public int findTheCity(int n, int[][] edges, int dt) {

            int[][] graph=new int[n][n];

            for(int i=0;i<n;i++ ){
                Arrays.fill(graph[i] ,(int)1e9);
                graph[i][i]=0;
            }
            for(int [] temp : edges){
                int r=temp[0];
                int c=temp[1];
                int w=temp[3];
                graph[r][c]=w;
                graph[c][r]=w;

            }
            for(int k=0;k<n;k++){

                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++) {

                        if(graph[i][k]!= (int)1e9  && graph[k][j] != (int)1e9){
                            graph[i][j]=Math.min(graph[i][j] ,graph[i][k]+graph[k][j]);

                        }
                    }
                }
            }

            int ans=(int)1e9;
            int IDX=-1;

            for(int i=0;i<n;i++){

                int abc=0;
                for(int j=0;j<n;j++){
                    if(i==j) continue;
                    if(graph[i][j]<=dt) abc++;
                }
                if(abc<=ans){
                    ans=abc;
                    IDX=i;
                }
            }
            return IDX;
        }
    }
    public static void main(String[] args) {

        L1334 obj=new L1334();
        L1334.Solution out= obj.new Solution();

        

    }
}
