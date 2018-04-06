package main.LeetCode;

import java.util.*;

public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 ||
                forest.get(0) == null || forest.get(0).size() == 0) {
            return 0;
        }
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return forest.get(p1.x).get(p1.y) - forest.get(p2.x).get(p2.y);
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new Point(i, j));
                }
            }
        }

        Point startPoint = new Point(0, 0);
        int total = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int steps = bfs(startPoint, p, m, n, forest);
            if (steps == -1) {
                return -1;
            }
            total += steps;
            startPoint = p;
        }
        return total;
    }

    private int bfs(Point startPoint, Point p, int m, int n, List<List<Integer>> forest) {
        int step = 0;
        if (startPoint.x == p.x && startPoint.y == p.y) {
            return 0;
        }
        int[] xs = new int[]{0, 1, -1, 0};
        int[] ys = new int[]{1, 0, 0, -1};
        boolean[][] visited = new boolean[m][n];
        visited[startPoint.x][startPoint.y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(startPoint);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int j = 0; j < size; j++) {
                Point pt = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = pt.x + xs[i];
                    int y = pt.y + ys[i];
                    if (x == p.x && y == p.y) {
                        return step;
                    }
                    if (x < 0 || y < 0 || x >= m ||
                            y >= n || visited[x][y] || forest.get(x).get(y) == 0) {
                        continue;
                    }
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
        return -1;
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
