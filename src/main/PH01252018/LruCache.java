package main.PH01252018;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
	int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node start = null;
    Node end = null;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        } else 
        return -1;
    }
    
    public void remove(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            start = n.next;
        }
        
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }
    }
    
    public void setHead(Node n) {
        n.prev = null;
        n.next = start;
        if (start != null) {
            start.prev = n;
        }
        
        start = n;
        
        if (end == null) {
            end = start;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            remove(n);
            setHead(n);
        } else {
            Node n = new Node(key, value);
            if (map.size() == this.capacity) {
                map.remove(end.key);
                remove(end);
                setHead(n);
            } else {
                setHead(n);
            }
            map.put(key, n);
        }
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}
