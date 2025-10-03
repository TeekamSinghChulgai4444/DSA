class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>>ans;
        int i=0;
        while(i<=rowIndex){
            vector<int>temp;
            if(i==0){
                temp.push_back(1);
                ans.push_back(temp);
                i++;
                continue;
            }
            for(int j=0;j<i;j++){
                if(j==0){
                    temp.push_back(1);
                    continue;
                }
                int sum=ans[i-1][j-1]+ans[i-1][j];
                temp.push_back(sum);
            }
            if(i!=0){
                temp.push_back(1);
            }
            ans.push_back(temp);
            i++;
        }
        return ans[rowIndex];
    }
};
