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
    TreeNode * pre=NULL;

    void helper(TreeNode* root,int & ans){
        if(root== NULL){
            return;
        }
        helper(root->left,ans);
        if(pre != NULL){
            int abc=abs(root->val - pre->val);
            ans=min(ans,abc);
        }
        pre=root;
       
        helper(root->right,ans);
       
    }
    int getMinimumDifference(TreeNode* root) {
        int ans=INT_MAX;
        helper(root,ans);
        return ans;
        
    }
};