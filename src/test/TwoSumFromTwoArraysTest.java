package test;

import main.Practice.Algorithm.TwoSumFromTwoArrays;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TwoSumFromTwoArraysTest {
    @Test
    public void testCase1() {
        TwoSumFromTwoArrays obj = new TwoSumFromTwoArrays();
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        int target = 7;
        for (List<Integer> list : obj.twoSum(arr1, arr2, target)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testCase2() {
        TwoSumFromTwoArrays obj = new TwoSumFromTwoArrays();
        int[] arr1 = new int[0];
        int[] arr2 = {2,2,4,6,8,10};
        int target = 8;
        for (List<Integer> list : obj.twoSum(arr1, arr2, target)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
