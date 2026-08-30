package Leetcode;

public class isBinarytree {

    static int s;

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
              this.right = right;
          }
    }
    public static int size(TreeNode root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }

    public static boolean CMT(TreeNode node ,int idx){
        if(node == null) return true;
        if(idx>s)return false;

        boolean left=CMT(node.left,idx*2);
        boolean right=CMT(node.right,idx*2+1);

        return left&&right;

    }

    public static boolean minHeap(TreeNode node){

        if(node.left==null && node.right==null || node == null){
            return true;
        }
        if(node.left != null && node.val >=node.left.val){
            return false;
        }
        if(node.right != null &&node.val>= node.right.val){
            return false;
        }

        boolean left=minHeap(node.left);
        boolean right=minHeap(node.right);

        return left&&right;

    }

    public boolean isCompleteTree(TreeNode root) {
        s=size(root);
        return CMT(root,1)&&minHeap(root);
    }
}
