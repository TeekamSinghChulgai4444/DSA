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
    
    int sol=0;
    void helper(int ans ,TreeNode* root ){
        if(root ==  NULL){
            return;
        }
        
        ans=(ans*10)+root->val;
        if(root->left == NULL && root->right == NULL){
            sol+=ans;
            return;
        }
       
        helper(ans, root->left);
        helper(ans, root->right);
    }
    
    int sumNumbers(TreeNode* root) {
        int inc=10;
        int ans=0;
        helper(ans, root);
        return sol;
    }
};