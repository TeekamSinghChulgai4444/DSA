class Solution {
public:
    void helper(TreeNode* root, int maxSoFar, int &ans) {
        if (root == NULL) {
            return;
        }
        if (root->val >= maxSoFar) {
            ans++;
        }
       
        maxSoFar = max(maxSoFar, root->val);
        helper(root->left, maxSoFar, ans);
        helper(root->right, maxSoFar, ans);
    }

    int goodNodes(TreeNode* root) {
        int ans = 0;
        helper(root, root->val, ans);
        return ans;
    }
};