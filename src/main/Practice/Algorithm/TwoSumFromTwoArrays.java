package main.Practice.Algorithm;

import java.util.*;

/**
 * 两个sorted array，找two sum 等于target的所有组合
 */

public class TwoSumFromTwoArrays {
    public List<List<Integer>> twoSum(int[] A, int[] B, int target) {
        Set<Integer> map = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if (A != null && A.length != 0) {
            for (int a : A) {
                if (!map.contains(a)) {
                    map.add(target - a);
                } else {
                    List<Integer> nList = new ArrayList<>();
                    nList.add(a);
                    nList.add(target - a);
                    result.add(nList);
                }
            }
        }

        if (B != null && B.length != 0) {
            for (int b : B) {
                if (!map.contains(b)) {
                    map.add(target - b);
                } else {
                    List<Integer> nList = new ArrayList<>();
                    nList.add(b);
                    nList.add(target - b);
                    result.add(nList);
                }
            }
        }
        return result;
    }
}
