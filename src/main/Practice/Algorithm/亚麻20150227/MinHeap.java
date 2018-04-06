package main.Practice.Algorithm.亚麻20150227;

import java.util.Arrays;

public class MinHeap {
    public int size;
    public int[] data;

    public MinHeap(int[] nums) {
        this.data = nums;
        this.size = nums.length;
    }

    public void buildMinHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyUp(i);
        }
    }

    public void heapifyUp(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && data[left] < data[smallest]) {
            smallest = left;
        }

        if (right < size && data[right] < data[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(smallest, i);
            heapifyUp(smallest);
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

    public void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public int extractMin() {
        int min = data[0];
        swap(0, size - 1);
        data[size - 1] = 0;
        size--;
        heapifyUp(0);
        return min;
    }
}
