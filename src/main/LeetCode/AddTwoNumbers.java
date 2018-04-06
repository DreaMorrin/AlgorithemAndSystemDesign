package main.LeetCode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            ListNode curr = new ListNode(0);
            int total = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            curr.val = total % 10;
            carry = total / 10;
            prev.next = curr;
            prev = curr;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
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
