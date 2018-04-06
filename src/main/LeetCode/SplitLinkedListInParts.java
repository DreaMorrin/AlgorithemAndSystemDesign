package main.LeetCode;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodes = new ListNode[k];
        int lens = 0;
        ListNode dummy = root;
        while (dummy != null) {
            lens++;
            dummy = dummy.next;
        }
        int n = lens / k, r = lens % k;
        ListNode node = root, prev = null;
        for (int i = 0; i < k && root != null; i++) {
            nodes[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            r--;
            prev.next = null;
        }
        return nodes;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode (int val) {
            this.val = val;
        }
    }
}
