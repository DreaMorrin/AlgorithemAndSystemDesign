package main.LeetCode;

public class ValidBST {
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return isValid;
    }

    private void dfs(TreeNode root, long max, long min) {
        if (root == null) {
            return;
        }
        if (root.left != null && (root.val <= root.left.val || root.left.val <= min)) {
            isValid = false;
        }
        if (root.right != null && (root.val >= root.right.val || root.right.val >= max)) {
            isValid = false;
        }
        dfs(root.left, root.val, min);
        dfs(root.right, max, root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int val) {
            this.val = val;
        }
    }
}
