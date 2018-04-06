package main.Practice.Algorithm.亚麻20150122;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountNumsPresentedOddTimes {

    public List<Integer> getNumsPresentedOddTimes(int[] nums) {

        Set<Integer> set = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(set);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return new ArrayList<>(set);
    }
}
