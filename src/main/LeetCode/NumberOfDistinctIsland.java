package main.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

 Example 1:
 11000
 11000
 00011
 00011
 Given the above grid map, return 1.
 Example 2:
 11011
 10000
 00001
 11011
 Given the above grid map, return 3.

 Notice that:
 11
 1
 and
 1
 11
 are considered different island shapes, because we do not consider reflection / rotation.
 Note: The length of each dimension in the given grid does not exceed 50.
 */

public class NumberOfDistinctIsland {
    int[][] xys = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> shapes = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    dfs(i, j, 0, 0, grid, builder);
                    if (shapes.add(builder.toString())) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int i0, int j0, int[][] grid, StringBuilder builder) {
        grid[i][j] = 0;
        builder.append(i0  + "" + j0);
        for (int k = 0; k < xys.length; k++) {
            int x = i + xys[k][0];
            int y = j + xys[k][1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                continue;
            }
            dfs(x, y, i0 + xys[k][0], j0 + xys[k][1], grid, builder);
        }
    }
}