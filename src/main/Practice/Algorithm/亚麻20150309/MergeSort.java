package main.Practice.Algorithm.亚麻20150309;

/**
 * 归并排序的时间复杂度： O(nlogn)
 * 空间复杂度：O(n), n 为待排序的数组长度
 */

public class MergeSort {
    public void sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[start + i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = nums[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
                k++;
            } else {
                nums[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

}



//    public void sort(int[] nums, int start, int end) {
//        if (start < end) {
//            int mid = start + (end - start) / 2;
//            sort(nums, start, mid);
//            sort(nums, mid + 1, end);
//            merge(nums, start, mid, end);
//        }
//    }
//
//    private void merge(int[] nums, int start, int mid, int end) {
//        int n1 = mid - start + 1;
//        int n2 = end - mid;
//
//        int[] left = new int[n1];
//        int[] right = new int[n2];
//        for (int i = 0; i < n1; i++) {
//            left[i] = nums[start + i];
//        }
//
//        for (int i = 0; i < n2; i++) {
//            right[i] = nums[mid + 1 + i];
//        }
//
//        int i = 0, j = 0;
//        int k = start;
//
//        while (i < n1 && j < n2) {
//            if (left[i] <= right[j]) {
//                nums[k] = left[i];
//                i++;
//                k++;
//            } else {
//                nums[k] = right[j];
//                j++;
//                k++;
//            }
//        }
//
//        while (i < n1) {
//            nums[k] = left[i];
//            k++;
//            i++;
//        }
//
//        while (j < n2) {
//            nums[k] = right[j];
//            k++;
//            j++;
//        }
//    }
