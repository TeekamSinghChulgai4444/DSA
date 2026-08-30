package leetCodeQuestion;

import Imp.*;

public class Reverse {

    public Node nodeReverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node nextt=null;

        while (curr != null) {
           nextt=curr.next;
           curr.next=prev;
           prev=curr;
           curr=nextt;
        }

        return prev;
    }

    public static void main(String[] args) {

        LinkedListList list = new LinkedListList();

        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);

        list.print();

        Reverse obj = new Reverse();

        Node newHead = obj.nodeReverse(list.getHead());

        list.setHead(newHead);

        list.print();
    }
}