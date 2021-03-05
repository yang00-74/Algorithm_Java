package com.nathan.array;

public class MoveZeros {

    /**
     * Move zeros to array end.
     * 使用两个指针 i 、j ，从头开始遍历
     *   i 一直向后移动，遇到非 0 元素则交换 nums[i] 和 nums[j]
     *   j 只在交换发生时才向后移动一位
     * @param nums the array
     */
    public static void moveZeros(int nums[]) {
        if (null == nums ) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }
}
