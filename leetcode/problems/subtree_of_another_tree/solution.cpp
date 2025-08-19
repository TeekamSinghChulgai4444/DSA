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
    bool intial(TreeNode* root, TreeNode* subRoot){
        if(root == NULL || subRoot == NULL){
            return root == subRoot;
        }
    
        bool lef = intial(root->left, subRoot->left);
        bool ref = intial(root->right, subRoot->right);

        return lef && ref && root->val == subRoot->val;
    }

    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(root == nullptr){
            return false; 
        }
        if(root->val == subRoot->val){
            if(intial(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
};