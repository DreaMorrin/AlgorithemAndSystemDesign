package main.Practice.Algorithm.亚麻20150227;

import main.Practice.Algorithm.亚麻20140723.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumSortedLinkedList {
    public int[] twoSumLinkedList(ListNode head, int target) {
        int[] res = new int[2];
        if (head == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1)) {
                continue;
            }
            int rest = target - list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == rest) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return res;
    }
}
