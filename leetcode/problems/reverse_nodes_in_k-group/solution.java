/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       
        int i=0;
        ListNode temp = head;

        while(i<k){
           
            if(temp == null){
                return head;
            }
            temp =temp.next;
            
            i++;
        }
        ListNode pre=reverseKGroup(temp,k);
        ListNode curr=head;
        ListNode nextt=null;
        int count=0;

        while(count<k){
            nextt=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nextt;
            count++;
        }
        return pre;
    }
}