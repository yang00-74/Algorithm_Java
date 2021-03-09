package com.nathan.array;

/**
 * 整数数组中只有一个/两个元素出现一次，其余都出现两次，找出它们来
 *
 * @author Administrator
 */
public class NumberAppearOnce136 {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 9, 4};
        int[] b1 = new int[1];
        int[] b2 = new int[1];
		System.out.println(find1From2(a));
    }

    /**
     * 思路：使用异或运算符^，0与其他数字异或的结果是那个数字，相等的数字异或得 0
     *
     * */
    public static int find1From2(int[] nums) {
        int len = nums.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
