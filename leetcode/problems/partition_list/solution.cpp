class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if (!head || !head->next) return head;

        ListNode *temp = head;

        ListNode *A1 = new ListNode(0);
        ListNode *big = A1;

        ListNode *A2 = new ListNode(0);
        ListNode *small = A2;

        while (temp != NULL) {
            if (temp->val < x) {
                small->next = new ListNode(temp->val);
                small = small->next;
            } else {
                big->next = new ListNode(temp->val);
                big = big->next;
            }
            temp = temp->next;
        }

        small->next = A1->next;
        return A2->next;
    }
};