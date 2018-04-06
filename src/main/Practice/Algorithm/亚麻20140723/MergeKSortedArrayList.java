package main.Practice.Algorithm.亚麻20140723;

import java.util.*;

public class MergeKSortedArrayList {
    public List<Integer> mergeKSortedArrayList(List<List<Integer>> lists) {
        List<Integer> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return res;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return i - j;
            }
        });

        Queue<Item> queue = new LinkedList<>();

        for (List<Integer> list : lists) {
            if (list != null || list.size() != 0) {
                queue.offer(new Item(list, 0));
            }
        }

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            int nextIndex = item.index + 1;
            pq.add(item.list.get(item.index));
            if (nextIndex < item.list.size()) {
                queue.add(new Item(item.list, nextIndex));
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        return res;
    }
}

class Item {
    List<Integer> list;
    int index;
    public Item(List<Integer> list, int index) {
        this.list = list;
        this.index = index;
    }
}
