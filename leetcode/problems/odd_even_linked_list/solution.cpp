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
    ListNode* oddEvenList(ListNode* head) {
        ListNode* temp =head;
        int i=1;
        ListNode *odd=NULL;
        ListNode *Otail=NULL;

        ListNode *even=NULL;
        ListNode *Etail=NULL;

        while(temp != NULL){
            
            if(i %2==0){
                    if(even==NULL){
                        ListNode *tempp=new ListNode(temp->val);
                        even=tempp;
                        Etail=tempp;
                    }else{
                        Etail->next=new ListNode(temp->val);;
                        Etail=Etail->next;
                    }
            }
            else{
                    if(odd==NULL){
                        ListNode *tempp=new ListNode(temp->val);
                        odd=tempp;
                        Otail=tempp;
                    }else{
                        Otail->next=new ListNode(temp->val);
                        Otail=Otail->next;
                    }

            }
            temp=temp->next;
            i++;
        }

        if(even != NULL){
            Otail->next=even;
        }
        return odd;

    }
};