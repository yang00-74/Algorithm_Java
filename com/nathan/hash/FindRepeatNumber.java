package com.nathan.hash;


public class FindRepeatNumber {

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     *
     * 本题中值得注意的一点是数字的范围与数组的长度相同，我们可以把数组看成是哈希表
     * 1. 把数组的索引看成是哈希表的键key，数组的元素看成哈希表的值val
     * 2. 把值为val的元素放在键也为val的位置上，也就是哈希表键值对的映射关系为key == val
     * 3. 如果当前数字 nums[i] 和索引 i 不相等，那么应该把 nums[i] 放在索引也为 nums[i] 的位置去，就把索引下标为 nums[i] 和 i 的元素对换
     * 4. 如果数组在索引为 nums[i] 位置的数在交换前就已经是 nums[i]，说明nums[i]是重复数字，返回nums[i]
     * 5. 如果交换后在 nums[i] 仍然不等于 i，要继续交换，使用while循环
     *
     * */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int element = nums[i];
            if (element == i) {
                // 不停调整下标 i 上的元素，直到元素值和下标值一致，接着处理下一个下标
                i++;
            } else {
                if (nums[element] == element) {
                    return element;
                } else {
                    // 将下标为 nums[i] 和 i 的两个元素交换
                    int temp = nums[element];
                    nums[element] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }

}
