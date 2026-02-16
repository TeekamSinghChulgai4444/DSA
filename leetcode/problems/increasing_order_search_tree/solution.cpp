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
    TreeNode *ans=NULL;

    TreeNode* increasingBST(TreeNode* root) {

        if(root==NULL){
            return NULL;
        }
        increasingBST(root->right);
        

        TreeNode* cmp=new TreeNode(root->val);

        if(ans==NULL){
            ans=cmp;
        }else{
            cmp->right=ans;
            cmp->left=NULL;
        }
        ans=cmp;

        increasingBST(root->left);
        return ans;
    }
};