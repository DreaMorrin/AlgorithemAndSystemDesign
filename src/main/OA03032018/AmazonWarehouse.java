package main.OA03032018;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 亚麻建了个新warehouse，从多个地点运东西过去，选择最近的k个点。就是k closest points，用priorityqueue。
 * 这题类似如下题目。
 *
 * Given somepointsand a pointoriginin two dimensional space, findkpoints out of the some points
 * which are nearest toorigin. Return these points sorted by distance, if they are same with
 * distance, sorted by x-axis, otherwise sorted by y-axis.
 *
 * Example
 * Given points =[[4,6],[4,7],[4,4],[2,5],[1,1]], origin =[0, 0], k =3
 * return[[1,1],[2,5],[4,4]]
 *
 * 解题思路参考：
 * 解决办法就是heap（priorityqueue），坑：要自己写comparator，注意比较距离的公式是x*x+y*y.
 *
 * Notes
 * int compare(T o1, T o2) 是“比较o1和o2的大小”
 * 返回“负数”，意味着“o1比o2小”；返回“零”，意味着“o1等于o2”；返回“正数”，意味着“o1大于o2”。
 */

public class AmazonWarehouse {
    public static void main(String[] args) {
        AmazonWarehouse aw = new AmazonWarehouse();
        Point[] pts = new Point[8];
        pts[0] = new Point(6, 9);
        pts[1] = new Point(2, 2);
        pts[2] = new Point(5, 10);
        pts[3] = new Point(5, 1);
        pts[4] = new Point(2, 3);
        pts[5] = new Point(1, 6);
        pts[6] = new Point(7, 10);
        pts[7] = new Point(6, 2);

        Point pt = new Point(4,5);

        for (Point p : aw.findKClosest(pt, 3, pts)) {
            System.out.println(p.toString());
        }
    }

    public List<Point> findKClosest(Point pt, int k, Point[] pts) {
        List<Point> list = new ArrayList<>();
        if (k == 0) {
            return list;
        }

        //max heap
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int diff = getDistance(pt, p2) - getDistance(pt, p1);
                if (diff == 0) {
                    diff = p1.x - p2.x;
                }
                if (diff == 0) {
                    diff = p1.y - p2.y;
                }
                return diff;
            }
        });

        int start = 0;
        while (start < pts.length) {
            pq.add(pts[start]);
            if (pq.size() > k) {
                pq.poll(); // remove maximum
            }
            start++;
        }

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }

    private int getDistance(Point pt, Point p1) {
        return (pt.x - p1.x) * (pt.x - p1.x) + (pt.y - p1.y) * (pt.y - p1.y);
    }

}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + ", " + this.y;
    }
}
