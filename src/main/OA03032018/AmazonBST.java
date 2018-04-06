package main.OA03032018;

import java.util.Arrays;

/**
 * 给一个无序integer array，要求用insert的方法建一个BST，然后给出其
 * 中两个值在树上的距离，若是有不在树里的，返回-1
 * 解题思路参考：
 * 千万注意这是一道大题！坑：首先给的integer array可能是有序的，就不需要排序了，否则可能会有case不过。
 * 再次是BST，不要按照BinaryTree搞，会超时导致case不过。解题思路，先建BST，再做LCA，然后算两点和root的距离（level）。
 * geekforgeek上的解释：http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 */

public class AmazonBST {
    public static void main(String[] args) {

        AmazonBST abst = new AmazonBST();
        int[] test = {5,6,3,1,2,4};
        System.out.println(abst.findBST(test, 6, 2));
    }

    public int findBST(int[] nums, int n1, int n2) {
        Arrays.sort(nums);
        TreeNode root = buildBST(nums, 0, nums.length - 1);
        printTree(root);
        return findDistance(root, n1, n2);

    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }

    private int findDistance(TreeNode node, int n1, int n2) {
        int x = findLevel(node, n1, 1);
        int y = findLevel(node, n2, 1);
        if (x == 0 || y == 0) {
            return -1;
        }

        int lca = findLevel(node, findLCABST(node, n1, n2).val, 1);
        return x + y - (2 * lca);
    }

    private int findPathLen(TreeNode root, int n) {
        return -1;
    }

    private int findLevel(TreeNode root, int n, int level) {
        if (root == null) {
            return 0;
        }
        if (root.val == n) {
            return level;
        } else if (root.val > n) {
            return findLevel(root.left, n, level + 1);
        } else {
            return findLevel(root.right, n, level + 1);
        }
    }

    private TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }

        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);

        if (right != null && left != null) {
            return root;
        }

        if (right != null) {
            return right;
        }

        if (left != null) {
            return left;
        }

        return null;
    }

    private TreeNode findLCABST(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (n1 > root.val && n2 > root.val) {
            return findLCABST(root.right, n1, n2);
        }

        if (n1 < root.val && n2 < root.val) {
            return findLCABST(root.left, n1, n2);
        }

        return root;
    }
}


