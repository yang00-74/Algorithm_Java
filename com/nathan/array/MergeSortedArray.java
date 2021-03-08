package com.nathan.array;

public class MergeSortedArray {

    /**
     * leet code 88 合并两个有序数组
     *
     * 使用 3 个指针记录数组关键下标：
     * p1 -> nums1 数组尾部
     * p2 -> nums2 数组尾部
     * p -> 最终数组尾部
     * 1.当 p1 >= 0 时，nums1[p1], nums2[p2]对比
     * A. nums1[p1]大，将 nums1[p1] 放入 nums1[p] 位置, p1--, p--
     * B. nums2[p2]大于等于 nums1[p1]，将nums2[p2]放入 nums1[p] 位置, p2--, p--
     * 2.当 p1 < 0 时，将 nums2[p2]放入 nums1[p] 位置, p2--,p--
     * 循环结束：p2<0
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        int end = m + n - 1;

        while (end2 >= 0) {
            if (end1 >= 0 && nums1[end1] > nums2[end2]) {
                nums1[end--] = nums1[end1--];
            } else {
                nums1[end--] = nums2[end2--];
            }
        }
    }

}
