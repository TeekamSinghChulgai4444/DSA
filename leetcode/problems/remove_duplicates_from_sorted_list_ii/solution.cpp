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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL){
            return NULL;
        }
   
    ListNode *ans=new ListNode(INT_MIN);
     ListNode*pre=ans;

    ListNode *temp=head;

    while(temp != NULL){
            if(temp->next !=NULL && temp->val == temp->next->val){
                        int vall=temp->val;
                        while(temp != NULL && temp->val == vall){
                            temp=temp->next;
                        }
            }
            
            else{
                        if(pre->val == INT_MIN){
                              pre->val=temp->val;
                          
                         }

                        else{
                                pre->next=new ListNode(temp->val);
                                pre=pre->next;
                        }
                        temp=temp->next;
            }
      
    }
    if(ans->val==INT_MIN){
        return NULL;
    }
    return ans;
        
    }
};