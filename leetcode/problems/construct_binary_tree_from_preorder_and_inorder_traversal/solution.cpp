/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int search(vector<int>& inorder, int x, int left, int right) {
        for(int i = left; i <= right; i++) {
            if(inorder[i] == x) {
                return i;
            }
        }
        return -1;
    }

    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int& preidx, int left, int right) {
        if(left > right) {
            return nullptr;
        }

        TreeNode* root = new TreeNode(preorder[preidx]);
        preidx++;

        int ind = search(inorder, root->val, left, right);

        root->left = helper(preorder, inorder, preidx, left, ind - 1);
        root->right = helper(preorder, inorder, preidx, ind + 1, right);

        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int left = 0;
        int right = inorder.size() - 1;
        int preidx = 0;
        return helper(preorder, inorder, preidx, left, right);
    }
};