class Solution {
public:
    TreeNode* helper(const vector<int>& ans, int first, int last) {
        if (first > last) return nullptr;

        int mid = first + (last - first) / 2;
        TreeNode* root = new TreeNode(ans[mid]);
        root->left = helper(ans, first, mid - 1);
        root->right = helper(ans, mid + 1, last);
        return root;
    }

    TreeNode* sortedListToBST(ListNode* head) {
        vector<int> ans;
        while (head) {
            ans.push_back(head->val);
            head = head->next;
        }
        return helper(ans, 0, ans.size() - 1);
    }
};