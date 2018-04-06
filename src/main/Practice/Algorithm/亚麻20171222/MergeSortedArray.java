package main.Practice.Algorithm.亚麻20171222;

/**
 * 88. merge two sorted array
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

 time complexity: O(m + n)
 space: O(1)
 */

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int index = m + n - 1;
        int s1 = m - 1;
        int s2 = n - 1;
        while (s1 >= 0 && s2 >= 0) {
            if (nums1[s1] > nums2[s2]) {
                nums1[index] = nums1[s1];
                s1--;
            } else {
                nums1[index] = nums2[s2];
                s2--;
            }
            index--;
        }

        while (s2 >= 0) {
            nums1[index] = nums2[s2];
            index--;
            s2--;
        }
    }
}
