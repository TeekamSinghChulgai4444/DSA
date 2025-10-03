class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        vector<pair<int,int>>st;
        
        int l=matrix.size();
        int n=matrix[0].size();

        for(int i=0;i<l;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    st.push_back({i,j});
                }
            }
        }
        for(pair<int,int>p : st){
            int i=p.first;
            int j=p.second;

            for(int i=0;i<l;i++){
                matrix[i][j]=0;
            }
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }

        }
    }
};