package main.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */

public class MostFrequentSubtreeSum {
    Map<Integer, Integer> sumMap;
    int countMax;
    public int[] findFrequentTreeSum(TreeNode root) {
        sumMap = new HashMap<>();
        countMax = 0;
        getSumsPostOrder(root);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getValue() == countMax) {
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int getSumsPostOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getSumsPostOrder(root.left);
        int right = getSumsPostOrder(root.right);
        int sum = left + right + root.val;
        int count = sumMap.getOrDefault(sum, 0);
        sumMap.put(sum, count + 1);
        countMax = Math.max(countMax, count + 1);
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
