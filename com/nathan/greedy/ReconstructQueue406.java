package com.nathan.greedy;

import java.util.*;

public class ReconstructQueue406 {
    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
     * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     *
     * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
     * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）
     *
     * 思路：排序,先按身高从大到小排，再按 k 从小到大排，再将 k 作为 index 插入到 list 对应位置
     * */
    public int[][] reconstructQueue(int[][] people) {

        // 排序,先按身高从大到小排，再按 k 从小到大排
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0];
        });
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            res.add(index, people[i]);
        }

        return res.toArray(new int[people.length][]);
    }
}
