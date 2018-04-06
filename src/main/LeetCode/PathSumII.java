package main.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        buildSolution(results, new ArrayList<Integer>(), root, sum);
        return results;
    }

    private void buildSolution(List<List<Integer>> results, List<Integer> list, TreeNode root, int sum) {
        if (root != null && root.left == null && root.right == null && sum == root.val) {
            list.add(root.val);
            results.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        } else if (root == null) {
            return;
        } else {
            sum = sum - root.val;
            list.add(root.val);
            if (root.left != null) {
                buildSolution(results, list, root.left, sum);
            }
            if (root.right != null) {
                buildSolution(results, list, root.right, sum);
            }
            list.remove(list.size() - 1);
            sum = sum + root.val;
        }
    }
}
