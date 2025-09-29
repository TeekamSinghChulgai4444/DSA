class Solution {
    public boolean helpr(TreeNode root, int sum) {
        if (root == null) return false;

        // Check if it's a leaf node and sum matches
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }

        // Recurse on left and right
        return helpr(root.left, sum - root.val) || helpr(root.right, sum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helpr(root, targetSum);
    }
}