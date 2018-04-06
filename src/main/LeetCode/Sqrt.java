package main.LeetCode;

/**
 * 69. Sqrt(x)
 Implement int sqrt(int x).

 Compute and return the square root of x.

 x is guaranteed to be a non-negative integer.
 */

public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int s = 0;
        int e = x;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (m <= (x / m)) {
                s = m;
            } else {
                e = m;
            }
        }

        return s;
    }
}
