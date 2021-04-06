package com.nathan.array;

public class RemoveDuplicates80 {
    /**
     * 删除有序数组中的重复项, 使每个元素 最多出现两次
     *
     * 思路：双指针，慢指针只在 nums[i] ！= nums[slow] 的时候才向前移动，并将快指针指向的元素赋值到慢指针位置
     * 另外额外使用计数器
     * */
    public int removeDuplicates(int[] nums){
        if (0 == nums.length) {
            return 0;
        }
        int slow = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                slow++;
                nums[slow] = nums[i];
                // 更新计数器
                count = 1;
            } else if (nums[slow] == nums[i] && count < 2) {
                slow++;
                nums[slow] = nums[i];
                // 更新计数器
                count++;
            }
        }
        return slow + 1;
    }
}
