class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        helper(root, ans);
        return ans;
    }

private:
    void helper(TreeNode* node, vector<int>& ans) {
        if (node == nullptr) return;
        helper(node->left, ans);
        ans.push_back(node->val);
        helper(node->right, ans);
    }
};