class Solution {
public:
    void helper(vector<vector<int>>& ans, vector<int> temp, int i) {
        temp.push_back(1); 

        for (int k = 1; k < i; k++) {
            temp.push_back(ans[i - 1][k - 1] + ans[i - 1][k]);
        }

        if (i > 0) temp.push_back(1); 

        ans.push_back(temp);
    }

    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> sol;
        vector<int> temp;

        for (int i = 0; i < numRows; i++) {
            temp.clear(); 
            helper(sol, temp, i);
        }

        return sol;
    }
};