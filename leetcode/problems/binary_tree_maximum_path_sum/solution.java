class Solution {
    static int mxsum;

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, sum(root.left));
        int right = Math.max(0, sum(root.right));

        mxsum = Math.max(mxsum, left + right + root.val);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        mxsum = Integer.MIN_VALUE; 
        sum(root);
        return mxsum;
    }
}