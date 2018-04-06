package main.LeetCode;

/**
 * 221. Maximal Square
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] =  1;
                    max = 1;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] == 1 && dp[i - 1][j - 1] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j] > 0) {
                    int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = (int) Math.pow(Math.sqrt(min) + 1, 2.0);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
