package com.nathan.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     * 返回一个表示每个字符串片段的长度的列表
     *
     * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。
     * 因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
     *
     * 在得到每个字母最后一次出现的下标位置之后，可以使用贪心的方法将字符串划分为尽可能多的片段，
     * 在遍历的过程中相当于是要找每一个字母的边界，「如果找到之前遍历过的所有字母的最远边界，说明这个边界就是分割点了」
     *
     * */
    public List<Integer> partitionLabels(String S) {
        int[] hash = new int[27];
        // 记录字母出现的最远下标
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        // 区间最右边下标
        int maxRight = 0;
        // 区间最左边下标
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            maxRight = Math.max(maxRight, hash[S.charAt(i) - 'a']);
            if (maxRight == i) {
                res.add(maxRight - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
