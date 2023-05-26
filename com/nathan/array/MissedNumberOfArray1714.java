package com.nathan.array;

/**
 * @author Ye.Yang
 * @date 19-7-25 下午2:26
 **/
public class MissedNumberOfArray1714 {


    public static void main(String[] args) {

        int[] a = new int[]{0, 0, 1, 2, 5, 6};

        int[] b = new int[]{1, 3, 4};

        System.out.println(MissedNumberOfArray1714.missingNumber(b));
    }

    /**
     * 数组元素在 0 - n-1 之间有序递增，但是有一个数是缺失的，要求找到这个缺失的数
     * 假设 n 为 3， 则数组可以为 [0,2], 其下标对应为 0，1，2
     * 使用异或运算，相同数字异或为 0，最后剩下的就是缺失的
     */
    public static int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }

}