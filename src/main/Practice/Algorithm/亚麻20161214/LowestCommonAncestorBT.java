package main.Practice.Algorithm.亚麻20161214;

import main.Practice.Algorithm.TreeNode;

public class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (right != null) {
            return right;
        } else {
            return left;
        }
    }
}
