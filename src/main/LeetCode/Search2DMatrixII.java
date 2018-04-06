package main.LeetCode;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col - 1;
        while (r < row && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
