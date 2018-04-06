package main.OA03032018;

import java.util.*;

/**
 *
 * 让小明帮公司球场修场地，给一个二维的链表fields，场地里有坑，不能走。 场地里有树要砍掉。最后目的返回是修好一层的场地的最小步数。
 * public int flatFields (int numRows, int numColumns, List<List<Integer>> fields) {}
 * Ex1:
 *
 * [1, 3, 0, 2].
 * [1, 1, 3, 1]
 * 上图中的1代表平地，可以走。 0代表坑，不能走。 大于1的数字代表树木，需要砍掉。
 * 规则是从上下左右四个角开始任选一个开始走，先砍数字小的树木。 比如2 < 3，那么就得先走2。
 * 上图如果从右下角开始走依次经过的坐标是：
 * （1， 3） -> (0, 3) -> (1, 3) -> (1, 2) -> (1, 1) -> (1, 0)
 * 所以返回的最小步数是5， 因为通过这个路径可以修平第二层的球场[1, 1, 3, 1]， 并且走到左下角终点。
 * Ex2:
 *
 * [1, 0]
 * [3, 2]
 * 上图中的最小步数返回-1因为，没有办法修好一层， 因为从左上角1开始走，不能走到0， 也不能走3，
 * 因为在全局中3比2大，必须先走2。所以就没法走了。
 *
 * 解题思路参考：
 * BFS来按照砍树顺序寻找最优路径。坑：先要找到所有树（>1的点），然后按照顺序做BFS。可以把树放到TreeMap里面（排序的HashMap).
 * 抽到的题目可能起始点是0.0也可能是四个角,没关系把起始点都放入queue中去做BFS即可。
 * 再有注意终点可能会是最后一棵树，也可能是最优路径走出来（从最后一棵数到任意四个点的最短路径）。
 * 参考答案是从四个点开始走最后走出来的解法。
 *
 */

public class GolfEvent {
    public static void main(String[] args) {
        GolfEvent ge = new GolfEvent();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 0, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 1, 4, 1));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 0, 2, 1));
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(ge.getPath(list, 1, 3));
    }

    public int getPath(List<List<Integer>> fields, int x, int y) {
        int[][] grid = flatFields(fields);
        if (fields == null || fields.size() == 0 ||
                fields.get(0) == null || fields.get(0).size() == 0) {
            return -1;
        }

        Map<Integer, Mark> map = new TreeMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    map.put(grid[i][j], new Mark(i, j, grid[i][j]));
                }
            }
        }

        Queue<Mark> queue = new LinkedList<>();
        Mark startPoint = new Mark(x, y, grid[x][y]), nMark = null;
        queue.offer(startPoint);
        int step = 0;
        for (Mark m : map.values()) {
            Mark copy = m;
            step = bfs(grid, queue, m);
            if (step == -1) {
                return -1;
            }
            step += step;
//            step += step + copy.val; // Add tree height
            queue.clear();
            nMark = new Mark(copy.x, copy.y, grid[copy.x][copy.y]);
            queue.offer(nMark);
        }
        return step;
//       有可能要求砍完树返回最近出口
//       queue.clear();
//       queue.add(new Mark(0, 0, grid[0][0]));
//       if (nMark != null) {
//           int rest = bfs(grid, queue, nMark);
//           if (rest != -1) {
//               step += rest;
//           }
//       }
//       return step;
    }

    private int bfs(int[][] grid, Queue<Mark> queue, Mark target) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] xs = new int[]{0, 1, -1, 0};
        int[] ys = new int[]{1, 0, 0, -1};
        int step = 0;
        while (!queue.isEmpty()) {
            Mark tmp = queue.poll();
            step++;
            for (int i = 0; i < 4; i++) {
                int x = xs[i] + tmp.x;
                int y = ys[i] + tmp.y;
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
                    continue;
                }
                if (target.x == x && target.y == y) {
                    grid[x][y] = 1; // cut the tree
                    return step;
                }
                if (grid[x][y] != 1) {
                    continue;
                }
                queue.offer(new Mark(x, y, grid[x][y]));
                visited[x][y] = true;
            }
        }
        return -1;
    }

    private int[][] flatFields(List<List<Integer>> fields) {
        int[][] grid = new int[fields.size()][fields.get(0).size()];
        for (int i = 0; i < fields.size(); i++) {
            for (int j = 0; j < fields.get(i).size(); j++) {
                grid[i][j] = fields.get(i).get(j);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        return grid;
    }
}

class Mark {
    int x;
    int y;
    int val;
    public Mark(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
