import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val); // Preorder: Root → Left → Right
        helper(root.left, ans);
        helper(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
}