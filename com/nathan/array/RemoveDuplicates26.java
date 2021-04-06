package com.nathan.array;

public class RemoveDuplicates26 {
    /**
     * 删除有序数组中的重复项
     *
     * 思路：双指针，慢指针只在 nums[i] ！= nums[slow] 的时候才向前移动，并将快指针指向的元素赋值到慢指针位置
     * */
    public int removeDuplicates(int[] nums){
        if (0 == nums.length) {
            return 0;
        }
        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow + 1;
    }
}
