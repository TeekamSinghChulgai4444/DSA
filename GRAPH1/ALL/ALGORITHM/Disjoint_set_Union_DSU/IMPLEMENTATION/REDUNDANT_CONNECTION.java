package ALGORITHM.Disjoint_set_Union_DSU.IMPLEMENTATION;

import java.util.*;

public class REDUNDANT_CONNECTION {
    class Solution {
        public int leader(int a){
            if(parents[a]==a)
                return a;
            return parents[a]=leader(parents[a]);
        }
        public boolean union(int a ,int b){

            int LeadA=leader(a);
            int LeadB=leader(b);

            if(parents[LeadA]==parents[LeadB])
                return true;

            if(size[LeadA]>size[LeadB]){
                parents[LeadB]=LeadA;
                size[LeadA]+=LeadB;
            }else{
                parents[LeadA]=LeadB;
                size[LeadB]+=LeadA;
            }
            return false;

        }
        static int[] parents;
        static int[] size;
        public int[] findRedundantConnection(int[][] edges) {
            int n= edges.length;
            parents=new int[n+1];
            size=new int[n+1];

            Arrays.fill(size,1);

            for(int i=1;i<=n;i++)
                parents[i]=i;

            for(int [] abc:edges){
                boolean check=union(abc[0],abc[1]);
                if(check)
                    return abc;
            }
            return size;
        }
    }
}
