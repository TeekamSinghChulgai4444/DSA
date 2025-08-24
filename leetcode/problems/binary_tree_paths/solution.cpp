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
    void helper(vector<string>& ans,string  temp, TreeNode *root){
        if(root==nullptr){
            return;
        }

       temp +=to_string(root->val);
        if(root->left==NULL && root->right==NULL){
            ans.push_back(temp);
            return;
        }
        temp+="->";
        
        helper(ans,temp,root->left);
        helper(ans,temp,root->right);
    
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string>ans;
        string temp ="";
        helper(ans,temp,root);
        return ans;
    }
};