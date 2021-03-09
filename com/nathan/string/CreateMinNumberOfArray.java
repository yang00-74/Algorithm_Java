package com.nathan.string;

import java.util.Arrays;

/**
 * 用数组中的元素组成一个最小的整数
 *
 * 剑指 Offer 45
 * @author Administrator
 */
public class CreateMinNumberOfArray {
    public static void main(String[] args) {
        int[] a = {45, 78, 1, 6};
        System.out.println(new CreateMinNumberOfArray().minNumber(a));
    }

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int len = nums.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        //重写排序规则
        Arrays.sort(str, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}