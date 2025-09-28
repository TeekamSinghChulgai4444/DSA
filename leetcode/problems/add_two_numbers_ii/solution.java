// import java.util.Stack;

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {}

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> A1 = new Stack<>();
        Stack<Integer> A2 = new Stack<>();

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null) {
            A1.push(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            A2.push(temp2.val);
            temp2 = temp2.next;
        }

        ListNode head =null;
        int carry=0;

        while( ! A1.isEmpty()  || ! A2.isEmpty() || carry !=0 ){
            int sum=carry;
            if(!A1.isEmpty()){
                sum+=A1.pop();
            }
            if(!A2.isEmpty()){
                sum+=A2.pop();
            }
            carry=sum/10;
            ListNode temp=new ListNode(sum%10);
            temp.next=head;
            head=temp;

        }
        return head;

    }
}