package com.nathan.leetcode.editor.cn;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 6902 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        // 元素总量为奇数
        if ((total & 1) == 1) {
            return getKthElement(nums1, nums2, total / 2 + 1);
        }
        return (getKthElement(nums1, nums2, total / 2)
                + getKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
    }

    /**
     * 从两个有序数组中找到第 k 小的数
     *   首先在两个有序数组中分别取 第 k/2 小的数，也就是下标为 k/2 -1 的元素，进行比较
     *   1. nums1[k/2 -1] >= nums2[k/2 -1] 时
     *       nums2[k/2 -1] 之前的数可以舍弃，k 减掉排除掉的元素个数
     *   2. nums1[k/2 -1] < nums2[k/2 -1]
     *       nums1[k/2 -1] 之前的数可以舍弃，k 减掉排除掉的元素个数
     * */
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true) {
            //边界情况，当index1越界时，直接返回nums2的第k小元素
            if(index1 == len1) {
                return nums2[index2 + k - 1];
            }
            //边界情况，当index2越界时，直接返回nums1的第k小元素
            if(index2 == len2) {
                return nums1[index1 + k - 1];
            }
            //边界情况，k等于1时，返回nums1第下标元素和nums2下标元素较小者
            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            // 防止数组越界
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;

            //比较nums1[k/2-1]和nums2[k/2-1]
            if(nums1[newIndex1] <= nums2[newIndex2]) {
                //如果nums1的小，则忽略掉nums1[0] ... nums1[k/2-1]这些元素
                //再更新 k，k 要减去忽略掉的那些元素，index1也要更新，待下轮使用
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                //如果nums2的小，则忽略掉nums2[0] ... nums2[k/2-1]这些元素
                //再更新 k，k 要减去忽略掉的那些元素，index2也要更新，待下轮使用
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
