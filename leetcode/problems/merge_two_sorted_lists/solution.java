class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0); // Dummy node
        ListNode temp = ans;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 == null) ? list2 : list1;

        return ans.next; // Skip dummy node
    }
}