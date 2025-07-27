/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
       bool hasCycle(ListNode *head) {
       ListNode *slow=head;
       ListNode *fast=head;
       if(head==NULL){
           cout<<"empty linked list : ";
           return false;
       }
   
       while(fast !=NULL && fast->next!=NULL){

           slow = slow->next;
           fast=fast->next->next;
           
           if(fast==slow){
               cout<<"ther is the cycle in linked list :";
               return true ;
           }
           
       }
       cout<<" there is no cycle in linked list :";
       return false;
           
    }
};