package main.LeetCode;

public class IntersactionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lensA = getLength(headA);
        int lensB = getLength(headB);
        while (lensA > lensB) {
            headA = headA.next;
            lensA--;
        }

        while (lensB > lensA) {
            headB = headB.next;
            lensB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getLength(ListNode head) {
        int lens = 0;
        while (head != null) {
            head = head.next;
            lens++;
        }
        return lens;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
