/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int sum = 0;

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();

        // Check if left child is a leaf
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            } else {
                queue.add(node.left);
            }
        }

        // Always add right child (but we don't sum its value)
        if (node.right != null) {
            queue.add(node.right);
        }
    }

    return sum;
}

}