package main.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        getSolutions(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }

    private void getSolutions(List<List<Integer>> results, List<Integer> list, int[] nums, int index) {
        results.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                getSolutions(results, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
