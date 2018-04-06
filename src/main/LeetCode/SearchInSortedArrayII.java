package main.LeetCode;

/**
 * 81. Search in Rotated Sorted Array II
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.


 */

public class SearchInSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if(nums[start] == nums[mid]) {
                start++; // 破坏平衡
            } else {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}
