class Solution {
    ListNode ans = new ListNode(0); // dummy node
    ListNode sol = ans; // pointer to build the merged list

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return ans.next;
        }

        if (list1 == null || list2 == null) {
            sol.next = (list1 == null) ? list2 : list1;
            return ans.next;
        }

        if (list1.val > list2.val) {
            sol.next = new ListNode(list2.val);
            sol = sol.next;
            mergeTwoLists(list1, list2.next);
        } else {
            sol.next = new ListNode(list1.val);
            sol = sol.next;
            mergeTwoLists(list1.next, list2);
        }

        return ans.next;
    }
}