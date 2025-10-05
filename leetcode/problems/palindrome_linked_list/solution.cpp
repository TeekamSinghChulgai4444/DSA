#include <stack>
using namespace std;

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
    bool isPalindrome(ListNode* head) {
        stack<int> ans;
        ListNode* temp = head;

        while (temp != nullptr) {
            ans.push(temp->val);
            temp = temp->next;
        }

        // Compare again from head
        temp = head;
        while (temp != nullptr) {
            if (temp->val != ans.top()) {
                return false;
            }
            ans.pop();
            temp = temp->next;
        }

        return true;
    }
};