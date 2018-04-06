package main.Practice.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class CheckIsConsecutiveArray {
    public boolean isConsecutiveArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int res = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num != 0) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(min + "\t" + max);
        int zeros = map.getOrDefault(0, 0);
        for (int i = min; i <= max - min; i++) {
            if (map.containsKey(i) && i != 0) {
                res++;
            } else if (zeros > 0) {
                zeros--;
            } else {
                return false;
            }
        }
        return true;
    }
}
