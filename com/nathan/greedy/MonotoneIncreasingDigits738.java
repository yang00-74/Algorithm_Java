package com.nathan.greedy;

public class MonotoneIncreasingDigits738 {

    /**
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增
     *
     * 要尽可能的大，那么这个数从高位开始要尽可能地保持不变。那么我们找到从高到低第一个满足 str[i]>str[i+1] 的位置，
     * 然后把 str[i] - 1 ，再把后面的位置都变成 9 即可
     * */
    public int monotoneIncreasingDigits(int N) {
        int max = -1;
        int maxIndex = -1;
        char[] nums = (N + "").toCharArray();

        for (int i = 0; i < nums.length - 1; i++) {
            // 对于各个位数上相同的数会将其相同数字的最高位记录为 maxIndex
            // 例如 1233332，max = 3， maxIndex = 2
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            // 一旦找到一个 高位比低位大的位置即可进行处理
            if (nums[i] > nums[i + 1]) {
                nums[maxIndex] -= 1;
                for (int j = maxIndex + 1; j < nums.length; j++) {
                    nums[j] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(nums));
    }
}
