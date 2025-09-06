class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* tail = head;

        while (tail != NULL && tail->next != NULL) {
            if (tail->val == tail->next->val) {
                ListNode* temp = tail->next;
                tail->next = temp->next;
                delete temp;
            } else {
                tail = tail->next;
            }
        }

        return head;
    }
};