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
    bool ans=true;
    void helper(TreeNode * root,int vall){
        if(root==NULL){
            return;
        }
        int abc=root->val;
        if(abc != vall){
            ans=false;
            return;
        }
        helper(root->left,vall);
        helper(root->right,vall);
    }
    bool isUnivalTree(TreeNode * root) {
        int vall=root->val;
        helper(root,vall);
        return ans;
        
    }
};