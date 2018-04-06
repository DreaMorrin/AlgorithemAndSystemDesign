package test;

import main.Practice.Algorithm.亚麻20150309.MergeSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void shouldSort() {
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        ms.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
