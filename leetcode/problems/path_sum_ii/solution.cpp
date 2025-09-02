class Solution {
public:
    vector<vector<int>> ans;

    void helper(TreeNode* root, vector<int> temp, int tar) {
        if (root == NULL) return;
        temp.push_back(root->val);

        if (root->left ==NULL && root->right == NULL && tar == root->val) {
            ans.push_back(temp);
        }

        helper(root->left, temp, tar - root->val);
        helper(root->right, temp, tar - root->val);
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> temp;
        helper(root, temp, targetSum);
        return ans;
    }
};