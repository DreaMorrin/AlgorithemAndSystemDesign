package main.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j) {
                return i - j;
            }
        });
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
