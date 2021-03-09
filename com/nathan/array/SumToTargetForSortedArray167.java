package com.nathan.array;

public class SumToTargetForSortedArray167 {

    /**
     * 在有序数组中找出两个数，使它们的和为 target.
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param nums   the sorted com.nathan.array {0, 0, 1, 2, 5, 6}
     * @param target the target sum
     * @return index com.nathan.array,else null
     */
    public static int[] sumToTarget(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            System.out.print("sum:" + sum + " index:" + i + "," + j);
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

}
