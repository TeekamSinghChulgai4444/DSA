class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int> numSet(nums.begin(), nums.end());
        ListNode* dummy = new ListNode(0);
        ListNode* tail = dummy;
        ListNode* curr = head;

        while (curr != nullptr) {
            if (numSet.find(curr->val) == numSet.end()) {
                tail->next = new ListNode(curr->val);
                tail = tail->next;
            }
            curr = curr->next;
        }

        return dummy->next;
    }
};