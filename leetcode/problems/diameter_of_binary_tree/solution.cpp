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
    int ans=0;
    int height(TreeNode* root){
        if(root ==nullptr){
            return 0;
        }
        int led=height(root->left);
        int righ=height(root->right);
        ans= max(ans,led+righ); 
        return max(led,righ)+1;   
    }

    int diameterOfBinaryTree(TreeNode* root) {
       int an=height(root);
       return ans;
    }
};