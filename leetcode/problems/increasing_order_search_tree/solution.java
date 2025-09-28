class Solution {
    TreeNode dummy = new TreeNode(0);
    TreeNode prev = dummy;

    public void solution(TreeNode root) {
        if (root == null) return;

        solution(root.left);

        prev.right = new TreeNode(root.val);
        prev = prev.right;

        solution(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        solution(root);
        return dummy.right; // skip dummy node
    }
}