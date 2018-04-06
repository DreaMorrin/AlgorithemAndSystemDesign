package test;

import main.Practice.Algorithm.亚麻20140723.FindKthElementToEndOfTheList;
import main.Practice.Algorithm.亚麻20140723.ListNode;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class FindKthElementToEndOfTheListTest {
    @Test
    public void testCase1() {
        FindKthElementToEndOfTheList obj = new FindKthElementToEndOfTheList();
        ListNode head = new ListNode(0);
        ListNode node = head;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(6);
        head = head.next;
        head.next = new ListNode(7);
        head = head.next;
        head.next = new ListNode(8);
        head = head.next;
        head.next = new ListNode(9);
        head = head.next;
        head.next = new ListNode(10);
        assertEquals(obj.findKthToEndOfTheList(node, 4).val, 7);
    }

    @Test
    public void testCase2() {
        FindKthElementToEndOfTheList obj = new FindKthElementToEndOfTheList();
        ListNode head = new ListNode(0);
        ListNode node = head;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(6);
        head = head.next;
        head.next = new ListNode(7);
        head = head.next;
        head.next = new ListNode(8);
        head = head.next;
        head.next = new ListNode(9);
        head = head.next;
        head.next = new ListNode(10);
        assertEquals(obj.findKthToEndOfTheList(node, 13), null);
    }

    @Test
    public void testCase3() {
        FindKthElementToEndOfTheList obj = new FindKthElementToEndOfTheList();
        ListNode head = new ListNode(0);
        ListNode node = head;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(6);
        head = head.next;
        head.next = new ListNode(7);
        head = head.next;
        head.next = new ListNode(8);
        head = head.next;
        head.next = new ListNode(9);
        head = head.next;
        head.next = new ListNode(10);
        assertEquals(obj.findKthToEndOfTheList(node, 0), null);
    }

    @Test
    public void testCase4() {
        FindKthElementToEndOfTheList obj = new FindKthElementToEndOfTheList();
        ListNode head = new ListNode(0);
        ListNode node = head;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(6);
        head = head.next;
        head.next = new ListNode(7);
        head = head.next;
        head.next = new ListNode(8);
        head = head.next;
        head.next = new ListNode(9);
        head = head.next;
        head.next = new ListNode(10);
        assertEquals(obj.findKthToEndOfTheList(node, 11).val, 0);
    }
}
