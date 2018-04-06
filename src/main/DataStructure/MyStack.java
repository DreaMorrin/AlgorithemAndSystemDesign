package main.DataStructure;

public class MyStack {

    ListNode head;

    public MyStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            this.head = new ListNode(val);
        } else {
            ListNode nHead = new ListNode(val);
            nHead.next = head;
            head = nHead;
        }
    }

    public int peek() {
        return head.val;
    }

    public int pop() {
        int top = head.val;
        ListNode node = head.next;
        head.next = null;
        head = node;
        return top;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

        myStack.push(-1);
        System.out.println(myStack.peek());

    }
}
