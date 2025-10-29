class Solution {
public:
    TreeNode* next = NULL;

    void flatten(TreeNode* root) {
        if (root == NULL) return;

        flatten(root->right);
        flatten(root->left);

        root->left = NULL;
        root->right = next;
        next = root;
    }
};