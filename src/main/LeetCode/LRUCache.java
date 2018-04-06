package main.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.end = null;
    }

    public void setHead(Node n) {
        n.prev = null;
        n.next = head;
        if (head != null) {
            head.prev = n;
        }
        head = n;
        if (end == null) {
            end = n;
        }
    }

    public void remove(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }
    }

    public int getKey(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = val;
            remove(n);
            setHead(n);
        } else {
            Node n = new Node(key, val);
            if (map.size() == capacity) {
                map.remove(end.key);
                remove(end);
            }
            map.put(key, n);
            setHead(n);
        }
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}


