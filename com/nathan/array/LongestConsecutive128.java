package com.nathan.array;


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive128 {

    /**
     *核心思路：
     * 如果我们知道了每一个连续序列的左边界，并且知道以它为左边界的连续序列的长度,进而就可以知道所有连续序列的长度,在其中取最大值即为结果。
     *
     * 但都有哪些数可以成为连续序列的左边界呢？
     *
     * 设想，如果num为一个左边界，那么num - 1就不应该存在于数组中（因为如果num - 1存在于数组中，num - 1又与num连续，所以num不可能是连续序列的左边界）。
     * 因此如果一个数字num满足：num-1不存在于数组中。这个数字num就可以成为连续序列的左边界。
     *
     * 具体的算法流程如下；
     *
     * 准备一个HashSet，将所有元素入set，之后遍历数组中的每一个数num
     *
     * 如果num - 1存在于set中，那么num不可能是左边界，直接跳过
     * 如果num - 1不存在于set中，那么num会是一个左边界，我们再不断地查找num+1、num+2......是否存在于set中，来看以num为左边界的连续序列能有多长
     * 在上述遍历中，我们知道了对于每一个可能的左边界，能扩出的最长连续序列的长度，再在这些长度中取最大即为结果。
     *
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-pf26/
     *
     * */
    public int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>(nums.length);
        for (int num : nums) {
            sets.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (sets.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while (sets.contains(num++)) {
                count++;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }

}
