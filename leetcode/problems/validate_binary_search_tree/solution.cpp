class Solution {
public:
    bool helper(TreeNode* root, long long st, long long end) {
        if (root == nullptr) return true;
        if (root->val <= st || root->val >= end) return false;
        return helper(root->left, st, root->val) &&
               helper(root->right, root->val, end);
    }

    bool isValidBST(TreeNode* root) {
        return helper(root, LLONG_MIN, LLONG_MAX);
    }
};