package main.LeetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    int capacity;
    Map<Integer, Node> nodeMap;
    Map<Integer, Integer> valueMap;
    Node head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(this.capacity, 1f);
        valueMap = new HashMap<>(this.capacity, 1f);
    }

    public void remove() {
        if (head == null) return;
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()) {
            remove(head);
        }
        valueMap.remove(oldest);
        nodeMap.remove(oldest);
    }

    public void remove(Node node) {
        if (head == node) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public void increase(int key, int val) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next == null) {
            node.next = new Node(node, null, node.count + 1, key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            node.next.prev = new Node(node, node.prev, node.count + 1, key);
            node.next = node.next.prev;
        }

        nodeMap.put(key, node.next);
        valueMap.put(key, val);
        if (node.keys.isEmpty()) {
            remove(node);
        }
    }

    public void add(int key) {
        if (head == null) {
            head = new Node(null, null, 1, key);
        } else if (head.count == 1) {
            head.keys.add(key);
        } else {
            head.prev = new Node(null, head, 1, key);
            head = head.prev;
        }
        nodeMap.put(key, head);
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increase(key, valueMap.get(key));
        }
        return valueMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (0 == this.capacity) return;
        if (valueMap.containsKey(key)) {
            increase(key, value);
        } else {
            if (valueMap.size() == this.capacity) {
                remove();
            }
            valueMap.put(key, value);
            add(key);
        }

    }

    public static class Node {
        public Node prev, next;
        public final int count;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        public Node(Node prev, Node next, int count, int key) {
            this.prev = prev;
            this.next = next;
            this.count = count;
            keys.add(key);
        }
    }
}
