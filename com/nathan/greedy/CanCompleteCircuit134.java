package com.nathan.greedy;

public class CanCompleteCircuit134 {
    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1
     *
     *思路：
     * 首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，说明 各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。
     *
     * 每个加油站的剩余量rest[i]为gas[i] - cost[i]。
     *
     * i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，起始位置从i+1算起，再从0计算curSum
     * */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            // 局部小于 0，说明起始位置必须要在 i 的右侧
            if (curSum < 0) {
                start = i + 1;
                // curSum从0开始
                curSum = 0;
            }
        }
        // 跑不了一圈
        if (total < 0) {
            return -1;
        }
        return start;
    }
}
