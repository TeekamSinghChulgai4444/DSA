import java.util.*;

class Solution {
    static Map<TreeNode, Integer> dp;

    public int level(TreeNode root){
        if(root == null){
            return 0;
        }

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        int left = level(root.left);
        int right = level(root.right);

        int height = Math.max(left, right) + 1;
        dp.put(root, height);

        return height;
    }

    public int diameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int ans = level(root.left) + level(root.right);

        int left = diameter(root.left);
        int right = diameter(root.right);

        return Math.max(ans, Math.max(left, right));
    }

    public int diameterOfBinaryTree(TreeNode root){
        dp = new HashMap<>();
        return diameter(root);
    }
}