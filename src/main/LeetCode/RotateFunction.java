package main.LeetCode;

/**
 * 396. Rotate Function
 Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int lens = A.length;
        int sum = 0;
        int F = 0;
        for (int i = 0; i < A.length; i++) {
            F += i * A[i];
            sum += A[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = lens - 1; i >= 0; i--) {
            F = F + sum - lens * A[i];
            max = Math.max(max, F);
        }
        return max;
    }
}
