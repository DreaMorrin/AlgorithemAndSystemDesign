package main.OA03042018;

import java.util.Arrays;

public class BstNodeDistance {
    public static void main(String[] args) {
        BstNodeDistance bnd = new BstNodeDistance();
        int[] test = {5,6,3,1,2,4};
        System.out.println(bnd.findDistance(test,2,5));
    }

    public int findDistance(int[] nums, int i, int j) {
        Arrays.sort(nums);
        TreeNode root = buildBST(nums, 0, nums.length - 1);
//        printBst(root);
        return findBSTDistance(root, i, j);
    }

    private int findBSTDistance(TreeNode root, int i, int j) {
        int x = findLevel(root, i, 1);
        int y = findLevel(root, j, 1);
        if (x == 0 || y == 0) {
            return -1;
        }
        TreeNode lca = findLca(root, i , j);
        int comm = findLevel(root, lca.val, 1);
        return x + y - (comm * 2);
    }

    private TreeNode findLca(TreeNode root, int i, int j) {
        if (root == null || root.val == i || root.val == j) {
            return root;
        }
        if (root.val > i && root.val < j) {
            return root;
        } else if (root.val > i && root.val > j) {
            return findLca(root.left, i, j);
        } else {
            return findLca(root.right, i, j);
        }

    }

    private int findLevel(TreeNode root, int val, int level) {
        if (root == null) {
            return 0;
        }
        if (val == root.val) {
            return level;
        } else if (val < root.val) {
            return findLevel(root.left, val, level + 1);
        } else {
            return findLevel(root.right, val, level + 1);
        }
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }

    private void printBst(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printBst(root.left);
        printBst(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
