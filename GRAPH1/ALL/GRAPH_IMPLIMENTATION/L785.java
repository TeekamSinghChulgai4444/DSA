package GRAPH_IMPLIMENTATION;

public class L785 {
    // IS GRAPH  BIPARTITE
    class Solution {
        static int [] parents;
        static int [] size;
        static boolean[] parity;

        public int leader(int a){
            if(parents[a]==a){
                return a;
            }
            return parents[a]=leader(parents[a]);
        }
        public boolean union(int a ,int b){
            int leadA=leader(a);
            int leadB=leader(b);

            if(leadA==leadB){
               if(parity[a]==parity[b]){
                   return true;
               }
            }else{
                if(size[leadA]>size[leadB]){
                    parents[leadB]=leadA;
                    size[leadA]+=size[leadB];
                    parity[b] = !parity[a];
                }else{
                    parents[leadA]=leadB;
                    size[leadB]+=size[leadA];
                    parity[a] = !parity[b];

                }
            }
            return false;
        }
        public boolean isBipartite(int[][] graph) {
            int n= graph.length;

            parents=new int[n];
            size= new int[n];
            parity=new boolean[n];

            for(int i=0;i<n;i++){
                parents[i]=i;
                size[i]=1;
                parity[i]=false;
            }

            for(int i=0;i<n;i++){
                for(int j:graph[i]){
                    if(j<i) continue;
                    if(union(j,i)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
