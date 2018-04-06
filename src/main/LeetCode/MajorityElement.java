package main.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (start < nums.length) {
            map.put(nums[start], map.getOrDefault(nums[start], 0) + 1);
            if (map.get(nums[start]) > nums.length / 2) {
                return nums[start];
            }
            start++;
        }
        return -1;
    }
}
