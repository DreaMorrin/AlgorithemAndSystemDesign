package main.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    int[][] grid;
    Set<Integer> shape;
    boolean[][] seen;
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0||
                grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        Set<Set<Integer>> shapes = new HashSet<>();
        seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.grid[i][j] == 1) {
                    shape = new HashSet<>();
                    bfs(i, j, i, j, m, n);
                    if (!shape.isEmpty()) {
                        shapes.add(shape);
                    }
                }
            }
        }
        return shapes.size();
    }

    private void bfs(int i, int j, int i0, int j0, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || seen[i][j] || grid[i][j] != 1) {
            return;
        }
        shape.add((i - i0) * 2 * n + j - j0);
        seen[i][j] = true;
        bfs(i + 1, j, i0, j0, m ,n);
        bfs(i, j + 1, i0, j0, m ,n);
        bfs(i - 1, j, i0, j0, m ,n);
        bfs(i, j - 1, i0, j0, m ,n);
    }
}
