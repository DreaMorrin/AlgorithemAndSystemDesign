package main.LeetCode;

public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode right = convertBST(root.right);
        sum += root.val;
        root.val = sum;
        TreeNode left = convertBST(root.left);
        return root;
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
