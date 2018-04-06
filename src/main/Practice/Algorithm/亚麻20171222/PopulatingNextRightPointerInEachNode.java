package main.Practice.Algorithm.亚麻20171222;

import main.Practice.Algorithm.TreeLinkNode;

public class PopulatingNextRightPointerInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        TreeLinkNode head = null;
        TreeLinkNode prev = null;

        while (node != null) {
            TreeLinkNode curr = node;
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            node = head;
            head = null;
            prev = null;
        }
    }
}
