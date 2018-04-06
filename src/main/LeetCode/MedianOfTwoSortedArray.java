package main.LeetCode;

public class MedianOfTwoSortedArray {
    /**
     * time: O(log(min(n,m)))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else {
                    R1 = R1 < R2 ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }

    /**
     * O(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int lens1, lens2, sumLens;
        lens1 = nums1.length;
        lens2 = nums2.length;
        sumLens = nums1.length + nums2.length;
        if (sumLens % 2 != 0) {
            return findKthSmallest(nums1, 0, lens1, nums2, 0, lens2, sumLens / 2 + 1);
        } else {
            return (findKthSmallest(nums1, 0, lens1, nums2, 0, lens2, sumLens / 2 + 1) + findKthSmallest(nums1, 0, lens1, nums2, 0, lens2, sumLens / 2)) / 2.0;
        }
    }

    private int findKthSmallest(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2, int k) {
        if (end1 > end2) {
            return findKthSmallest(nums2, begin2, end2, nums1, begin1, end1, k);
        }
        if (end1 == 0) {
            return nums2[begin2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[begin1], nums2[begin2]);
        }

        int partA = Math.min(k / 2, end1);
        int partB = k - partA;
        if (nums1[begin1 + partA - 1] == nums2[begin2 + partB - 1]) {
            return nums1[begin1 + partA - 1];
        } else if (nums1[begin1 + partA - 1] > nums2[begin2 + partB - 1]) {
            return findKthSmallest(nums1, begin1, end1, nums2, begin2 + partB, end2 - partB, k - partB);
        } else {
            return findKthSmallest(nums1, begin1 + partA, end1 - partA, nums2, begin2, end2, k - partA);
        }
    }
}
