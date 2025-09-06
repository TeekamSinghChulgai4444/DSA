class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* ans = new ListNode(0);
        ListNode* soll = ans;
        int rem = 0;

        while (l1 != NULL && l2 != NULL) {
            int a = l1->val + l2->val + rem;
            rem = a / 10;
            ans->next = new ListNode(a % 10);
            ans = ans->next;
            l1 = l1->next;
            l2 = l2->next;
        }

        while (l2 != NULL) {
            int a = l2->val + rem;
            rem = a / 10;
            ans->next = new ListNode(a % 10);
            ans = ans->next;
            l2 = l2->next;
        }

        while (l1 != NULL) {
            int a = l1->val + rem;
            rem = a / 10;
            ans->next = new ListNode(a % 10);
            ans = ans->next;
            l1 = l1->next;
        }

        if (rem > 0) {
            ans->next = new ListNode(rem);
        }

        return soll->next;
    }
};