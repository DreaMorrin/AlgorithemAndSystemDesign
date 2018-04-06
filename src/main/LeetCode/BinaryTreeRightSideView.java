package main.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199 Binary Tree Right Side View
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
     1            <---
   /   \
  2     3         <---
   \     \
    5     4       <---
 You should return [1, 3, 4].


 */

public class BinaryTreeRightSideView {
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        findItems(root, 0);
        return list;
    }

    private void findItems(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }

        findItems(root.right, level + 1);
        findItems(root.left, level + 1);
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
