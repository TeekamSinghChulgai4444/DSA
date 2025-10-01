class Solution {
public:
int count(ListNode*head){
    int count=0;
        ListNode*temp=head;
        while(temp!=NULL){
            temp=temp->next;
            count++;
        }
        return count;
      

}
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode*temp1=headA;
        ListNode*temp2=headB;
        
    while(temp1!=NULL&&temp2!=NULL){
        if(temp1==temp2){
            return temp1;
        }
        if(count(temp1)<count(temp2)){ 
            temp2=temp2->next;

        }
        else if(count(temp1)>count(temp2)){
            temp1=temp1->next;
        }
        else if(count(temp1)==count(temp2)){
            temp1=temp1->next;
            temp2=temp2->next;
        }
       

    }
    return NULL;
        
    }
};