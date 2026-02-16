class Solution {
public:
    void Ans(TreeNode* root, vector<int>& ans) {
        if (!root) return;
        ans.push_back(root->val);
        Ans(root->left, ans);
        Ans(root->right, ans);
    }

    int findSecondMinimumValue(TreeNode* root) {
        vector<int> ans;
        Ans(root, ans);

        sort(ans.begin(), ans.end());

        int minVal = ans[0];
        for (int i = 1; i < ans.size(); i++) {
            if (ans[i] > minVal) {
                return ans[i];
            }
        }

        return -1;
    }
};
