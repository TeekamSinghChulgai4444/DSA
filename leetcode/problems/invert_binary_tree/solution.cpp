class Solution {
public:
    TreeNode* helper(TreeNode* root) {
        if (root == nullptr) {
            return nullptr;
        }

        TreeNode* newNode = new TreeNode(root->val);
 
        newNode->left = helper(root->right);
        newNode->right = helper(root->left);

        return newNode;
    }

    TreeNode* invertTree(TreeNode* root) {
        return helper(root);
    }
};