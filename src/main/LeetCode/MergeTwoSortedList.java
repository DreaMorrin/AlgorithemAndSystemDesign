package main.LeetCode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode nHead = new ListNode(0);
        ListNode iter = nHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                iter.next = l2;
                l2 = l2.next;
            } else {
                iter.next = l1;
                l1 = l1.next;
            }
            iter = iter.next;
        }

        if (l1 == null) {
            iter.next = l2;
        }
        if (l2 == null) {
            iter.next = l1;
        }
        return nHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
