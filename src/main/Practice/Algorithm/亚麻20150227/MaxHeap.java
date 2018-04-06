package main.Practice.Algorithm.亚麻20150227;

import java.util.Arrays;

public class MaxHeap {
    public int[] data;
    public int size;

    public MaxHeap(int size) {
        this.data = new int[size]; // 因为索引不从节点0开始，所以长度加1
        this.size = size;
    }

    public MaxHeap(int[] nums) {
        this.data = nums;
        this.size = nums.length;
    }

    public void buildMaxHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyUp(i);
        }
    }

    public void heapSort() {
        int tmpSize = size;
        for (int i = 0; i < data.length; i++) {
            int temp = data[0];
            data[0] = data[size - 1];
            data[size - 1] = temp;
            size--;
            heapifyUp(0);
        }
        size = tmpSize;
    }

    public void heapifyUp(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && data[left] > data[largest]) {
            largest = left;
        }

        if (right < size && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(largest, i);
            heapifyUp(largest);
        }
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }



    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
