package main.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;

                int sum = left + right + 1;
                res = Math.max(res, sum);
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return res;
    }
}
