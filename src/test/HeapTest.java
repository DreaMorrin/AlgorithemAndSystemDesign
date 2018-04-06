package test;

import main.PH01252018.Heap;
import main.Practice.Algorithm.亚麻20150227.MaxHeap;
import main.Practice.Algorithm.亚麻20150227.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class HeapTest {
    @Test
    public void testCase1() {
        int[] nums = new int[]{13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MinHeap h = new MinHeap(nums);
        h.buildMinHeap();
        h.print();
        h.heapSort();
        h.print();
//        assertEquals(h.extractMin(), 1);
    }

    @Test
    public void testCase2() {
        int[] nums = new int[]{13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MinHeap h = new MinHeap(nums);
        h.buildMinHeap();
        h.print();
        assertEquals(h.extractMin(), 1);
        assertEquals(h.size, 12);
        assertEquals(h.extractMin(), 2);
        assertEquals(h.extractMin(), 3);
        assertEquals(h.extractMin(), 4);
    }

    @Test
    public void maxHeapTestCase1() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        MaxHeap maxHeap = new MaxHeap(nums);
        maxHeap.buildMaxHeap();
        maxHeap.print();
        maxHeap.heapSort();
        maxHeap.print();
    }
}
