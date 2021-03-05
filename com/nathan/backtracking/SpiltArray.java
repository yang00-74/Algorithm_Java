package com.nathan.backtracking;


/**
 *
 *  划分数组为相等的两部分,回溯法
 * */
public class SpiltArray {

    int[] a = new int[20];
    int count = 0;
    int sum = 0;
    int[] nums = {1, 2, 3, 4};

    public void spiltArray(int startIndex, int target) {

        if (target == sum) {
            for (int i = 0; i <= count - 1; i++) {
                System.out.print(a[i] + ",");
            }
            System.out.println(" ");
        }
        if (sum > target) return;
        int length = nums.length;
        for (int i = startIndex; i < length; i++) {
            a[count++] = nums[i];
            sum += nums[i];
            spiltArray(i + 1, target); //数组元素不可复用, index +1
            sum -= nums[i];
            a[--count] = 0;
        }
    }
}
