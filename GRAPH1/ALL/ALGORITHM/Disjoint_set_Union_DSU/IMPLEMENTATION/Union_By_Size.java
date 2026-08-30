package ALGORITHM.Disjoint_set_Union_DSU.IMPLEMENTATION;

public class Union_By_Size {
    static int[] parents;
    static int[] size;

    public int find(int a){
        if(parents[a]==a)
            return a;
        return find(parents[a]);
    }
    public void union(int a,int b){
        int leaderA=find(a);
        int leaderB=find(b);

       if(size[leaderA]>size[leaderB]) {
           parents[leaderB] = leaderA;
           size[leaderB] += size[leaderA];
       }
       else {
           parents[leaderA] = leaderB;
           size[leaderA] += size[leaderB];
       }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        size=new int[n+1];
        parents =new int[n+1];

        for(int i=1;i<=n;i++){
            parents[i]=i;
            size[i]=1;
        }
        size[0]=1;
        parents[0]=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1)
                    union(i+1,j+1);
            }
        }

        int count=0;
        for(int i=1;i<=n;i++)
            if(parents[i]==i)  count++;

        return count;
    }
}
