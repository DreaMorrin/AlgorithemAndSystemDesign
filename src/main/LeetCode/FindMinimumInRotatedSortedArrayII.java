package main.LeetCode;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        return findMinRecursive(nums, 0, nums.length - 1);
    }

    public int findMinRecursive(int[] nums, int start, int end) {
        int min = nums[end];
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] == nums[end] && nums[mid] == nums[start]){
                return Math.min(findMinRecursive(nums, mid, end), findMinRecursive(nums, start, mid));
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
