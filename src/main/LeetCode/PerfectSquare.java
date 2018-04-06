package main.LeetCode;

/**
 * 367. Valid Perfect Square
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 */

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int start = 0;
        int end = num;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < (num / mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == num || end * end == num) {
            return true;
        }
        return false;
    }
}
