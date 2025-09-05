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

    void helper(TreeNode* A,TreeNode* B){
        if(A == NULL && B != NULL || B == NULL && A != NULL){
            ans=false;
        }
        if(A==NULL || B==NULL ){
            return ;
        }
        if(A->val != B->val){
            ans=false;
        }
        helper(A->left,B->right);
        helper(A->right,B->left);
    }
    bool isSymmetric(TreeNode* root) {
      TreeNode *abc=root->left;
      TreeNode *adc=root->right;
      helper(abc,adc);
        return ans;

    }
};