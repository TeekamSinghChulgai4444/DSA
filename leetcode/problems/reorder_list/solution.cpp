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
    void reorderList(ListNode* head) {
        stack<int>s;
        queue<int>q;
        ListNode* temp=head;


        while(temp!=NULL){
            s.push(temp->val);
            q.push(temp->val);
            temp=temp->next;
        }

        ListNode*abc=head;
        int i=0;
        while(abc!=NULL){
            if(i%2==0){
                abc->val=q.front();
                q.pop();
            }else{
                abc->val=s.top();
                s.pop();
            }
            abc=abc->next;
            i++;
        }
        
    }
};