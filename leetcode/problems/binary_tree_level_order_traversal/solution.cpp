class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        vector<int> temp;
        queue<TreeNode*> level;

        if (root == NULL) {
            return ans;
        }

        level.push(root);
        level.push(NULL);

        while (!level.empty()) {
            TreeNode* tempp = level.front();
            level.pop();

            if (tempp == NULL) {
                ans.push_back(temp);
                temp.clear();
                if (!level.empty()) {
                    level.push(NULL);
                }
            } else {
                temp.push_back(tempp->val);
                if (tempp->left != NULL) {
                    level.push(tempp->left);
                }
                if (tempp->right != NULL) {
                    level.push(tempp->right);
                }
            }
        }

        return ans;
    }
};