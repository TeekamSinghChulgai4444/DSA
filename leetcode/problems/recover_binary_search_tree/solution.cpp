class Solution {
public:
    TreeNode *prev = nullptr;
    TreeNode *first = nullptr;
    TreeNode *sec = nullptr;

    void inorder(TreeNode* root) {
        if (!root) return;

        inorder(root->left);

        if (prev && root->val < prev->val) {
            if (!first) {
                first = prev;
            }
            sec = root;
        }
        prev = root;

        inorder(root->right);
    }

    void recoverTree(TreeNode* root) {
        inorder(root);
        if (first != nullptr) {
            int temp = first->val;
            first->val = sec->val;
            sec->val = temp;
        }
    }
};