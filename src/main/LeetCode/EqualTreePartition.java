package main.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.

 Example 1:
 Input:
     5
    / \
   10 10
  /  \
 2   3

 Output: True
 Explanation:
     5
    /
   10

 Sum: 15

    10
   /  \
  2    3

 Sum: 15
 Example 2:
 Input:
     1
    / \
   2  10
  /  \
 2   20

 Output: False
 Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tr
 */

public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = getSums(root, sumMap);
        if (sum == 0) {
            return sumMap.getOrDefault(sum, 0) > 1;
        }
        return sum % 2 == 0 && sumMap.containsKey(sum / 2);
    }

    private int getSums(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = getSums(root.left, map);
        int right = getSums(root.right, map);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
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
