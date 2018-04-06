package main.LeetCode;

/**
 *
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i
 to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique
 解题思路：
 当一个数组的综合是大于0 的时候，肯定至少有一个点是可以使得指针绕数组走一圈
 1. 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明什么？说明从i到i+1，i+2，...肯定是正积累。
 2. 现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程(废话)。
 那么，我们要从位置i+1开始重新尝试吗？不需要！为什么？因为前面已经知道，位置i肯定是正积累，
 那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。同理，也不用从i+2，i+3，...开始尝试。
 所以我们可以放心地从位置j+1开始尝试。

 Reference: http://www.cnblogs.com/boring09/p/4248482.html
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 ||
                cost == null || cost.length == 0) {
            return -1;
        }
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0) {
            return -1;
        }

        tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int currGain = gas[i] - cost[i];
            tank += currGain;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}
