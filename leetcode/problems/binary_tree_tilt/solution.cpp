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

  
    int helper(TreeNode* root,int& sum){
        if(root== NULL){
            return 0;
        }
        int left=helper(root->left,sum);
        int right=helper(root->right,sum);
        sum+=abs(left-right);
        return left+right+root->val;
    }

    int findTilt(TreeNode* root) {
        
        int sum=0;
        helper(root,sum);
        return sum;
    }
};