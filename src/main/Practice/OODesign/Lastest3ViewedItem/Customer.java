package main.Practice.OODesign.Lastest3ViewedItem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Customer {
    private String name;
    private PriorityQueue<Item> pq;

    public Customer (String name) {
        this.name = name;
        this.pq = new PriorityQueue<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return i1.getTimeStamp() - i2.getTimeStamp();
            }
        });
    }

    public void viewItem(Item item) {
        this.pq.add(item);
    }
}
