package main.LeetCode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int start = 0;
        int end = nums.length - 1;
        int min = nums[end];
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
