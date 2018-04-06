package main.LeetCode;

public class TwoSumIISortedArray {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }

        int[] res = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (target < numbers[start] + numbers[end]) {
                end--;
            } else if (target > numbers[start] + numbers[end]) {
                start++;
            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
        }
        return res;
    }
}
