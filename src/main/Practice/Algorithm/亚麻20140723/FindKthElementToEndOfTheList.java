package main.Practice.Algorithm.亚麻20140723;

public class FindKthElementToEndOfTheList {
    public ListNode findKthToEndOfTheList(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (fast != null) {
            if (i == k) {
                break;
            }
            fast = fast.next;
            i++;
        }

        if (i != k) {
            return null;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
