package main.Practice.Algorithm;

public class QuickSort {
    public void quick_sort(int[] A, int start, int end) {
        if (start < end) {
            int left = start;
            int right = end;

            // 1. Pivot, A[start], A[end];
            // get value not index
            int pivot = A[start + (end - start) / 2];

            // 2. left <= right not left < right

            while (left <= right) {
                while (left <= right && A[left] < pivot) {
                    left++;
                }

                while (left <= right && A[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;
                    left++;
                    right--;
                }
            }

            quick_sort(A, start, right);
            quick_sort(A, left, end);
        }
    }
}
