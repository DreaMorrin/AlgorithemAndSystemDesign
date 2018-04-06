package main.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] ary = new int[]{9,8,7,6,5,4,3,2,1};
        bs.bubbleSort(ary);
        System.out.println(Arrays.toString(ary));
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
