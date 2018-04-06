package main.OA03042018;

import java.util.*;

public class CutOffGoldTrees {
    public int cutOffTree(List<List<Integer>> forest) {
        int sum = 0;
        if (forest == null || forest.size() == 0 ||
                forest.get(0) == null || forest.get(0).size() == 0) {
            return sum;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                return forest.get(p1.x).get(p1.y) - forest.get(p2.x).get(p2.y);
            }
        });
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new Point(i, j));
                }
            }
        }
        int m = forest.size();
        int n = forest.get(0).size();
        Point startPoint = new Point(0, 0);
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int step = bfs(p, forest, startPoint, m, n);
            if (step == -1) {
                return -1;
            }
            sum += step;
            startPoint = p;
        }
        return sum;
    }

    private int bfs(Point point, List<List<Integer>> forest, Point start, int m, int n) {
        if (start.x == point.x && start.y == point.y) {
            return 0;
        }
        int[] xs = new int[]{0, 1, -1, 0};
        int[] ys = new int[]{1, 0, 0, -1};
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int k = 0; k < size; k++) {
                Point p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + xs[i];
                    int y = p.y + ys[i];
                    if (x == point.x && y == point.y) {
                        return step;
                    }
                    if (x < 0 || y < 0 || x >= m || y >= n ||
                            visited[x][y] || forest.get(x).get(y) == 0) {
                        continue;
                    }
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}