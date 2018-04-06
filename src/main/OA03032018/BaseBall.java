package main.OA03032018;

import java.util.Stack;

/**
 *
 * Given a string array representing a throw ball blocks, each string is either a number,
 * +, Z, X. Calculate total. If number, just add to total. If +, add last 2 scores to total.
 * If Z, remove last score from total. If X, double last score and add to toal.
 * Use 0 for any missing last score. 有些 corner cases 要考虑。
 * 打棒球得分，给了一个String[] input，求最终score
 * 如果是 integer， 就加给score（有负值）
 * 如果是“x”, 将上一个值double ，加给score； 若没有上一个值，上一个值按0 计算
 * 如果是“z”, 上一个成绩作废， score 剪掉上一值
 * 如果是“+”，将上两个值相加，然后加给score
 *
 */

public class BaseBall {

    public static void main(String[] args) {
        BaseBall bb = new BaseBall();
        String[] scores = new String[]{"5", "X", "3", "Z", "-3"};
        String[] scores2 = new String[]{"5", "2", "C", "D", "+"};
        System.out.println(bb.getScore(scores));
        System.out.println(bb.calPoints(scores2));
    }

    public int getScore(String[] scores) {
        int sum = 0;
        if (scores == null || scores.length == 0) {
            return sum;
        }

        Stack<Integer> stack = new Stack<>();
        int start = 0;
        while (start < scores.length || stack.empty()) {
            int prevScore = 0;
            if (!stack.empty() && scores[start].equals("Z")) {
                sum -= stack.pop();
            } else if (!stack.empty() && scores[start].equals("X")) {
                prevScore = stack.peek() * 2;
                sum += prevScore;
                stack.push(prevScore);
            } else if (scores[start].equals("+")) {
                int size = stack.size();
                if (size >= 2) {
                    prevScore = stack.get(size - 1) + stack.get(size - 2);
                } else if (size == 1) {
                    prevScore = stack.peek();
                }
                stack.push(prevScore);
                sum += prevScore;
            } else {
                prevScore = Integer.parseInt(scores[start]);
                stack.push(prevScore);
                sum += prevScore;
            }
            start++;
        }
        return sum;
    }

    public int calPoints(String[] ops) {
        int sum = 0;
        if (ops == null || ops.length == 0) {
            return sum;
        }
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        while (start < ops.length) {
            int val = 0;
            if (ops[start].equals("C") && !stack.empty()) {
                val = stack.pop();
                sum -= val;
            } else if (ops[start].equals("D") && !stack.empty()) {
                val = stack.peek();
                sum += val * 2;
                stack.push(2 * val);
            } else if (ops[start].equals("+") && !stack.empty()) {
                int size = stack.size();
                if (size > 1) {
                    val = stack.get(size - 1) + stack.get(size - 2);
                } else if (size == 1) {
                    val = stack.get(size - 1);
                }
                sum += val;
                stack.push(val);
            } else {
                val = Integer.parseInt(ops[start]);
                sum += val;
                stack.push(val);
            }
            start++;
        }
        return sum;
    }
}
