package main.LeetCode;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return map.get(a) - map.get(b) == 0 ? b.compareTo(a) : map.get(a) - map.get(b);
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll());
        }
        return list;
    }
}
