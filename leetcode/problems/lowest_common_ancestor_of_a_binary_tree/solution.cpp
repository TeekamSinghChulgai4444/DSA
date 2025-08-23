/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr){
            return nullptr;
        }
        
        if(root==p ||  root == q){
            return root;
        }
        
        TreeNode *leftlca= lowestCommonAncestor(root->left,p,q);
        TreeNode *rightlca= lowestCommonAncestor(root->right,p,q);

        if(leftlca  != nullptr && rightlca != nullptr ){
             return root;
        }

        else if(leftlca  != nullptr){
             return leftlca;
        }

        else{
             return rightlca;
        }
    }
};