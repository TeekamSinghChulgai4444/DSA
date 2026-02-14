class Solution {
public:

    vector<int> findOriginalArray(vector<int>&v) {

        sort(v.begin(),v.end());

        int n=v.size();

        vector<int>ans;
        vector<bool>check(n,false);


        for(int i=0;i<n;i++){
            if(check[i]){
                continue;
            }
            for(int j=i+1;j<n;j++){

                if(v[i]*2 == v[j] && !check[j]){
                    check[i]=true;
                    check[j]=true;
                    ans.push_back(v[i]);
                    break;
                }
            }
            if(!check[i]){
                return {};
            }
        }
        
        return ans;
    }
};