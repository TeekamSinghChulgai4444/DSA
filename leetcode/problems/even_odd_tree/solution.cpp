class Solution {
public:
    bool isEvenOddTree(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        int i = 0; // level index (0 = even, 1 = odd)
        int pre = INT_MIN;

        while (!q.empty()) {
            TreeNode *curr = q.front();
            q.pop();

            if (curr == NULL) {
                // level finished
                if (q.empty()) return true;
                q.push(NULL);
                i = 1 - i; // switch level
                pre = (i == 0) ? INT_MIN : INT_MAX; // reset correctly
                continue;
            }

            int val = curr->val;

            // Parity check
            if (i == 0) { // even level -> values must be odd & strictly increasing
                if (val % 2 == 0 || val <= pre) return false;
            } else { // odd level -> values must be even & strictly decreasing
                if (val % 2 == 1 || val >= pre) return false;
            }
            pre = val;

            if (curr->left) q.push(curr->left);
            if (curr->right) q.push(curr->right);
        }
        return true;
    }
};
