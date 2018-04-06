package main.PH01252018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class MulDiv {
	Set<Integer> set = new HashSet<>();
	List<String> list = new ArrayList<String>();	
	public static void main(String[] args) {
		MulDiv md = new MulDiv();
		TreeNode root = new TreeNode(1);
		TreeNode dummy = root;
		md.calculate(28, root);
		
		md.inorder(dummy);
		for (String s : md.list) {
			System.out.println(s);
		}
		String[] strArr = (String[]) md.list.toArray();
	}
	
	public void inorder(TreeNode dummy) {
		if (dummy == null) {
			return;
		}
		inorder(dummy.left);
		inorder(dummy.right);
	}
	
	public void calculate(int target, TreeNode root) {
		if (root.val == target) {
			return;
		} else if (root.val > target) {
			if (!set.contains(root.val)) {
				list.add("DIV");
				root.right = new TreeNode(root.val / 3);
				calculate(target, root.right);
			}
		} else {
			if (!set.contains(root.val)) {
				list.add("MUL");
				root.left = new TreeNode(root.val * 2);
				calculate(target, root.left);
			}
		}
	}
}
