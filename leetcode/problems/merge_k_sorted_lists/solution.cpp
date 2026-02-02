class Solution {
public:
    ListNode* add(ListNode* l, ListNode* l2) {

        if (l == NULL) return l2;
        if (l2 == NULL) return l;

        ListNode* Ans = NULL;
        ListNode* tail = NULL;

        while (l != NULL && l2 != NULL) {

            if (l->val > l2->val) {

                if (Ans == NULL) {
                    Ans = l2;
                    tail = l2;
                } else {
                    tail->next = l2;
                    tail = l2;
                }
                l2 = l2->next;
            }
            else {

                if (Ans == NULL) {
                    Ans = l;
                    tail = l;
                } else {
                    tail->next = l;
                    tail = l;
                }
                l = l->next;
            }
        }

        if (l != NULL) {
            tail->next = l;
        } else {
            tail->next = l2;
        }

        return Ans;
    }

    ListNode* mergeKLists(vector<ListNode*>& lists) {

        int n = lists.size();
        if (n == 0) return NULL;
        if (n == 1) return lists[0];

        ListNode* base = lists[0];

        for (int i = 1; i < n; i++) {
            base = add(base, lists[i]);
        }

        return base;
    }
};
