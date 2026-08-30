package Leetcode;

import java.util.*;

public class BSTtoMAXHEAP {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    class solution {

        static ArrayList<Integer> abc = new ArrayList<>();
        static int index;

        public static void inorder(Node root) {
            if (root == null) return;

            inorder(root.left);
            abc.add(root.data);
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) return;

            postorder(root.left);
            postorder(root.right);

            root.data = abc.get(index++);
        }

        public static void convertToMaxHeapUtil(Node root) {
            abc.clear();
            index = 0;

            inorder(root);
            postorder(root);
        }
    }
}