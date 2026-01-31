class Solution {
public:
    vector<int> productExceptSelf(vector<int> ans) {

        int n = ans.size();
        vector<int> right(n, 0);

        int temp1 = 1;
        for (int j = n - 1; j >= 0; j--) {
            right[j] = temp1;
            temp1 *= ans[j];
        }

        int left = 1;
        vector<int> Answer;

        for (int i = 0; i < n; i++) {
            Answer.push_back(left * right[i]);
            left *= ans[i];
        }

        return Answer;
    }
};