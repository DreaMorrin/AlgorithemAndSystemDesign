package main.DataStructure;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] initArray = new int[]{1,4,2,5,3,9,11,13,7,0};
        Heap heap = new Heap();
        heap.heapSort(initArray, 10);
        System.out.println();
        heap.heapSort2(initArray, 10);
        System.out.println(Arrays.toString(initArray));
    }

    public void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        /* find the largest index */
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }

        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }
        /* end of finding the largest index */

        if (largest != i) {
            // swap the largest number to the parent position;
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            this.heapify(nums, n, largest);
        }
    }

    public void heapifyDown(int[] nums, int n, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && nums[l] < nums[smallest]) {
            smallest = l;
        }

        if (r < n && nums[r] < nums[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            int temp = nums[i];
            nums[i] = nums[smallest];
            nums[smallest] = temp;
            heapifyDown(nums, n, smallest);
        }
    }

    public void heapifyUp(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapifyUp(nums, n, largest);
        }
    }

    public void heapSort(int[] nums, int end) {
        int n = end;
        int beginIndex = (n / 2) - 1; // Because heapify starts at parent nodes
        for (int i = beginIndex; i >= 0; i--) {
            this.heapify(nums, n, i);
            System.out.println(Arrays.toString(nums));
        }
    }

    // end is the lens of the array
    public void heapSort2(int[] nums, int end) {
        int n = end;
        int beginIndex = (n / 2) - 1; // Because heapify starts at parent nodes
        for (int i = beginIndex; i >= 0; i--) {
            this.heapifyDown(nums, n, i);
            System.out.println(Arrays.toString(nums));
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            this.heapifyDown(nums, i, 0);
        }
    }
}
