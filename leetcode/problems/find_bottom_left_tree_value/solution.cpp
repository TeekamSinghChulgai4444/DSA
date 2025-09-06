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
    int findBottomLeftValue(TreeNode* root) {
        queue<TreeNode *>q;
        q.push(root);
        q.push(NULL);
        int maxx=root->val;

        while(q.size()>0){
            TreeNode * curr=q.front();
            q.pop();
            if(curr==NULL){
                if(q.size()==0)
                    break;
            
                    q.push(NULL);
                
                maxx=q.front()->val;
            }else{
                if(curr->left != NULL){
                    q.push(curr->left);
                }
                if(curr->right != NULL){
                    q.push(curr->right);
                }
            }
        }
        return maxx;
    }
};