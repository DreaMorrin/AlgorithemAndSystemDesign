package main.LeetCode;

import main.Practice.Algorithm.亚麻20150122.RandomListNode;

/**
 *
 * 138. Copy List with Random Pointer
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        //copy node
        RandomListNode node = head;
        while (node != null) {
            RandomListNode nNode = new RandomListNode(node.label);
            nNode.next = node.next;
            node.next = nNode;
            node = nNode.next;
        }

        //copy random
        node = head;
        while (node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //decouple
        RandomListNode node2 = head.next;
        RandomListNode ret = node2;
        node = head;
        while (node2 != null) {
            node.next = node2.next;
            node = node.next;
            if (node != null) {
                node2.next = node.next;
            }
            node2 = node2.next;
        }
        return ret;
    }
}
