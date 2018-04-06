package main.Practice.Algorithm.亚麻20170910;

import main.Practice.Algorithm.TreeNode;

public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidDfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidDfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        boolean isValid = true;
        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val <= min) {
                isValid = false;
            } else {
                isValid &= isValidDfs(root.left, min, root.val);
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val >= max) {
                isValid = false;
            } else {
                isValid &= isValidDfs(root.right, root.val, max);
            }
        }

        return isValid;
    }
}
