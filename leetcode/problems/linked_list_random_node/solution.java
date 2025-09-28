import java.util.Random;

class Solution {
    private ListNode head;
    private int length;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
        this.length = 0;

        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
    }

    public int getRandom() {
        int index = rand.nextInt(length); // random index from 0 to length-1
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
}