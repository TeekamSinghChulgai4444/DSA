class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* tail = head;
        int count = 0;
        while (tail != NULL) {
            count++;
            tail = tail->next;
        }

        int target = count - n;
        if (target == 0) {
            ListNode* temp = head;
            head = head->next;
            delete temp;
            return head;
        }

        int i = 1;
        tail = head;
       while(i<target){
        tail=tail->next;
        i++;
       }
       ListNode *temp=tail->next;
       tail->next=tail->next->next;
       delete temp;
    
        return head;
    }
};