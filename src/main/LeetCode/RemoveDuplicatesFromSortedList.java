package main.LeetCode;

import main.Practice.Algorithm.亚麻20140723.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (prev.val == curr.val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
