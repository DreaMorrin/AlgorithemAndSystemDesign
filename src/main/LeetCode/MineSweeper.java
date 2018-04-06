package main.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Point start = new Point(click[0], click[1]);
        visited[start.x][start.y] = true;
        int[] xs = new int[]{0, 1, -1, 0, 1, -1, 1, -1};
        int[] ys = new int[]{1, 0, 0, -1, 1, -1, -1, 1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (board[p.x][p.y] == 'M') {
                board[p.x][p.y] = 'X';
            } else {
                char count = '0';
                for (int i = 0; i < 8; i++) {
                    int x = p.x + xs[i];
                    int y = p.y + ys[i];
                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }
                    if (board[x][y] == 'M' || board[x][y] == 'X') {
                        count++;
                    }
                }
                if (count > '0') {
                    board[p.x][p.y] = count;
                } else {
                    board[p.x][p.y] = 'B';
                    for (int i = 0; i < 8; i++) {
                        int x = p.x + xs[i];
                        int y = p.y + ys[i];
                        if (x < 0 || y < 0 ||
                                x >= m || y >= n ||
                                visited[x][y]) {
                            continue;
                        }
                        // board[x][y] = 'B';
                        queue.offer(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
        return board;
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
