package main.LeetCode;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return partition(lists, 0, lists.length - 1);

    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = partition(lists, start, mid);
        ListNode right = partition(lists, mid + 1, end);
        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }

        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
