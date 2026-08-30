package UniqueBinarySearchTree;

public class L124 {
    static int mxSum = Integer.MIN_VALUE;

    public class Node {
        public int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }

    static int ind = 0;

    public Node create(int[] arr) {
        if (ind >= arr.length || arr[ind] == -1) {
            ind++;
            return null;
        }

        Node root = new Node(arr[ind++]);
        root.left = create(arr);
        root.right = create(arr);

        return root;
    }

    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public int maxSum(Node root) {
        if (root == null) return 0;

        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));

        mxSum = Math.max(mxSum, left + right + root.data);

        return root.data + Math.max(left, right);
    }

    public static void main(String[] args) {
        int arr[] = {0};

        L124 obj = new L124();

        Node root = obj.create(arr);

        obj.preOrder(root);
        System.out.println();

        obj.maxSum(root);

        System.out.println("Max Sum: " + mxSum);
    }
}