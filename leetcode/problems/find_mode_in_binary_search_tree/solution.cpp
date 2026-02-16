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
    void Ans(TreeNode* root, map<int,int>&mp){
        if(root==NULL){
            return;
        }
        if(mp.find(root->val)!= mp.end()){
            mp[root->val]++;
        }else{
            mp.insert({root->val,1});
        }
        Ans(root->left, mp);
        Ans(root->right,mp) ;

        return;
    }

    vector<int> findMode(TreeNode* root) {

        map<int , int >mp;

        Ans(root,mp);
        int fre=0;

        for( auto it : mp){
             fre=max(fre,it.second);
        }
        vector<int>ans;

        for(auto it : mp){
            if(it.second==fre){
                ans.push_back(it.first);
            }
        }
        
        return ans;
    }
};