package com.nathan.array;

public class MaxSumValueOfArray {


    @org.junit.Test
    public void test() {
        int[] arr = new int[]{1, 2, 3};
        int[] values = new int[]{100, 2, 1};

        System.out.println(getMaxValue(arr, values));
    }

    /**
     * 给定数组 nums 和 values，每次从 values 中取第 i 个元素，nums 只能从首尾取，每个元素只能使用一次，
     * 按照 values[i] * nums[首/尾] 累加和，求最大的和
     */
    public static int getMaxValue(int[] nums, int[] values) {
        int numStart = 0;
        int numTail = nums.length - 1;
        int preMax = 0;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            int firstResult = value * nums[numStart];
            int lastResult = value * nums[numTail];
            int max = firstResult;
            if (firstResult < lastResult) {
                numTail--;
                max = lastResult;
            } else {
                numStart++;
            }
            preMax = preMax + max;
        }
        return preMax;
    }

}
