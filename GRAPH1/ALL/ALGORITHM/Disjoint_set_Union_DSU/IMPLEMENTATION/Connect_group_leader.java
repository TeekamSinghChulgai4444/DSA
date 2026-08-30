package ALGORITHM.Disjoint_set_Union_DSU.IMPLEMENTATION;

public class Connect_group_leader {
    static int parents[];
    public int find (int a){
        if(parents[a]==a)
            return a;
        return find(parents[a]);

    }
    public void union (int a , int b){
        int leaderA=find(a);
        int leaderB=find(b);

        parents[leaderA]=leaderB;
    }
    public int ByGroup(int[][] edge){
        int n= edge.length;
        parents=new int[n+1];

        for(int i=1 ;i<n;i++)
             parents[i]=i;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edge[i][j]==1){
                    union(i+1,j+1);
                }
            }
        }
        // our main target is that find the total components in the graph.
        int count =0;

        for(int i=1;i<n;i++){
            if(parents[i]==i)
                count++;
        }
        return count;

    }
    public static void main(String[] args) {

    }
}
