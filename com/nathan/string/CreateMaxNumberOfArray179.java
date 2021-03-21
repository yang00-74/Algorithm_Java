package com.nathan.string;

import java.util.Arrays;

/**
 * 用数组中的元素组成一个最大的整数
 *
 * @author Administrator
 */
public class CreateMaxNumberOfArray179 {
    public static void main(String[] args) {
        int[] a = {45, 78, 1, 6};
        System.out.println(new CreateMaxNumberOfArray179().largestNumber(a));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int len = nums.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        //重写排序规则
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (str[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    // TODO 快排实现排序

}