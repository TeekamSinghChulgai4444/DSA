class Solution {
public:
    int count = 0;
    int result ;

    void helper(TreeNode* root, int k) {
        if (!root) return;

        helper(root->left, k);

        count++;
        if (count == k) {
            result = root->val;
            return; 
        }

        helper(root->right, k);
    }

    int kthSmallest(TreeNode* root, int k) {
        helper(root, k);
        return result;
    }
};