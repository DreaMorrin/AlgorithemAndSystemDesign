package main.OA03032018;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.

 * ParkingLot an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
 * to the original tree structure.

 * For example, you may serialize the following tree

 *      1
 *    /  \
 *   2    3
 *  / \
 * 4   5
 * as "[1,2,3,null,null,4,5]", just the same as how main.LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.

 * Credits:
 * Special thanks to @Louis1992 for adding this problem and creating all test cases.
 */

public class SerializeDeserializeBT {
    private static String SP = ",";
    private static String NA = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NA).append(SP);
            return;
        }
        sb.append(root.val).append(SP);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SP)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (NA.equals(val)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }
}
