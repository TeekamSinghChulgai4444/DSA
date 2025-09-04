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
    int index(vector<int>arr,int st, int end){
         int mx=INT_MIN;
        int ind=-1;
        for(int i=st;i<=end;i++){
            if(arr[i]>mx){
               mx=arr[i];
               ind=i;
            }
        }

        return ind;
 
    }

    TreeNode *construct(vector<int>arr,int st,int end){
        if(st>end){
           return NULL;
        }
        int ind=index(arr,st,end);
        TreeNode* root=new TreeNode(arr[ind]);
        root->left=construct(arr,st,ind-1);
        root->right=construct(arr,ind+1,end);
        return root;
    }

    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        int st=0;
        int end=nums.size()-1;
        TreeNode * ans=construct(nums,st,end);
        return ans;
    }
    
};