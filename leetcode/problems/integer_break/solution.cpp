class Solution {

public:
void  anse(int n,int i,vector<int>&temp,vector<vector<int>>&result){
   
    if(n==0){
         result.push_back(temp);
         return;

    }
   for(int j=i;j<=n;j++){
        temp.push_back(j);
        anse(n-j,j,temp,result);
        temp.pop_back();
   }
  
}
int integerBreak(int n) { 
        if(n==2){
        return 1;
    }
    if(n==3){
        return 2;
    }
    vector<vector<int>>result;
    vector<int>ans;

    int maxans=0;
   
    anse(n,1,ans,result);

    int m=result.size();
    for(int i=0;i<m;i++){
         int anser=1;
        for(int j=0;j<result[i].size();j++){
            anser=anser*result[i][j];
        }
       maxans=max(anser,maxans);
        
    }
    return maxans;
}
        
    
};