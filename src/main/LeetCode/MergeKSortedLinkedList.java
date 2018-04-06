package main.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode nHead = new ListNode(0);
        ListNode iterator = nHead;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            iterator.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            iterator = iterator.next;
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
