package Imp;

import  Imp.Node;
public class LinkedListList {
    
    private Node head;
    private Node tail;
    private int size;

    public void pushFront(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void pushBack(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void popFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void popBack() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    public int front() {
        if (head == null) throw new RuntimeException("Empty list");
        return head.val;
    }

    public int back() {
        if (tail == null) throw new RuntimeException("Empty list");
        return tail.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public Node getHead(){
        return head;
    }
    public void setHead(Node head){
        this.head=head;
    }

  
}
