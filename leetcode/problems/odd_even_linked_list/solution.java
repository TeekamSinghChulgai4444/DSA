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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode Temp = head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode Even = even;
        ListNode Odd = odd;
        int i = 0;

        while(Temp != null){
            if(i % 2 == 0){
                Odd.next = new ListNode(Temp.val);
                Odd = Odd.next;
            } else {
                Even.next = new ListNode(Temp.val);
                Even = Even.next;
            }
            Temp = Temp.next;
            i++;
        }
        ListNode sol = odd.next;
        Odd.next = even.next;
        return sol;
    }
}