class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        vector<vector<int>>sol;
        vector<int>temp;

        int n=matrix.size();
        int m;
        for(vector<int>a : matrix){
             m=a.size();
            break;
        }

        for(int i=0;i<m;i++){
            temp.clear();
            for(int j=n-1;j>=0;j--){
                temp.push_back(matrix[j][i]);
            }
            sol.push_back(temp);
        }
        matrix=sol;
    }
};