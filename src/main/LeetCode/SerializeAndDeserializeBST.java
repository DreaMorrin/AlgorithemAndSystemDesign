package main.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    private static final String SP = ",";
    private static final String NIL = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildTree(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private void buildTree(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(NIL).append(SP);
            return;
        }
        builder.append(root.val).append(SP);
        buildTree(root.left, builder);
        buildTree(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SP);
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return recoverTree(queue);
    }

    private TreeNode recoverTree(Queue<String> queue) {
        String node = queue.poll();
        if (node.equals(NIL)) {
            return null;
        } else {
            int val = Integer.parseInt(node);
            TreeNode root = new TreeNode(val);
            root.left = recoverTree(queue);
            root.right = recoverTree(queue);
            return root;
        }
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
