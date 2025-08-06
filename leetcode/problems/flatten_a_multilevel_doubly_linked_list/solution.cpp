/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    Node* flatten(Node* head) {
        Node *curr=head;
        while(curr!=NULL){
            if(curr->child != NULL){
                Node* abc =curr->next;
                curr->next=flatten(curr->child);
                curr->next->prev=curr;
                curr->child=NULL;
                while(curr->next!=NULL){
                    curr=curr->next;
                }
                if(abc!=NULL){
                    curr->next=abc;
                    abc->prev=curr;
                }
            }
            else{
                curr=curr->next;
            }
        }
        return head;
        
    }
};