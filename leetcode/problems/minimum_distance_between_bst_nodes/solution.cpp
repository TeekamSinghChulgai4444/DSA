class Solution {
public:
    TreeNode* prev = NULL;
    int minn = INT_MAX;

    void inorder(TreeNode* root) {
        if (root==nullptr) return;

        inorder(root->left);
        if (prev != NULL) {
            minn = min(minn, root->val - prev->val);
        }
        prev = root;
        inorder(root->right);
    }

    int minDiffInBST(TreeNode* root) {
        inorder(root);
        return minn;
    }
};