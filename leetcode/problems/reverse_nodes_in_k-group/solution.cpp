/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode *temp;
        ListNode *nextt;

        int count=0,i=0;
        temp=head;
        while(count<k){
            count++;
            if(temp==NULL){
                return head;
            }
            temp=temp->next;
        }
        ListNode *prev=reverseKGroup(temp,k);
        temp=head;

        while(i<k){
            i++;
           nextt=temp->next;
           temp->next=prev;
           prev=temp;
           temp=nextt;
        }
        return prev;
        
    }
};