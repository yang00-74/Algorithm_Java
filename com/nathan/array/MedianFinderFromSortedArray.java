package com.nathan.array;

/**
 * 两个有序数组的中位数
 */
class MedianFinderFromSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        System.out.println(findMedianSortedArray(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        //如果A数组长度+B数组长度total是奇数，则找total/2+1小的元素即为中位数
        if((total & 1) == 1) {
            int midIndex = total / 2 + 1;
            return getKthElement(nums1, nums2, midIndex);
        } else {
            //否则，找total/2，total/2+1这两个元素
            int midIndex_1 = total / 2;
            int midIndex_2 = total / 2 + 1;
            double a = getKthElement(nums1, nums2, midIndex_1);
            double b = getKthElement(nums1, nums2, midIndex_2);
            return (a + b) / 2.0D;
        }
    }

    /**
     * 从两个有序数组中找到第 k 小的数
     *   首先在两个有序数组中分别取 第 k/2 小的数，也就是下标为 k/2 -1 的元素，进行比较
     *   1. nums1[k/2 -1] >= nums2[k/2 -1] 时
     *       nums2[k/2 -1] 之前的数可以舍弃，k 减掉排除掉的元素个数
     *   2. nums1[k/2 -1] < nums2[k/2 -1]
     *       nums1[k/2 -1] 之前的数可以舍弃，k 减掉排除掉的元素个数
     * */
    private int getKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while(true) {

            int targetIndex1 = Math.min(index1 + k / 2, len1) - 1;
            int targetIndex2 = Math.min(index2 + k / 2, len2) - 1;

            if (nums1[targetIndex1] >= nums2[targetIndex2]) {
                k -= (targetIndex2 - index2 + 1);
                index2 = targetIndex2 + 1;
            } else {
                k -= (targetIndex1 - index1 + 1);
                index1 = targetIndex1 + 1;
            }

            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }

            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

        }
    }



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
            //边界情况，k等于1时，返回nums1第一个元素和nums2第一个元素较小者
            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
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

    /**
     *  两个有序数组，nums1 长度为 m， nums2 长度为 n，假设将其存到了一个有序的 m+n 长度数组 nums 中，
     *  此时要求 nums 的中位数，不管其长度为奇数还是偶数，必然有：
     *     mid * 2 = nums[(n+m-1)/2] + nums[(n+m)/2]
     *  则转换问题为确定 nums[(n+m-1)/2]、 nums[(n+m)/2] 元素，处理时合并两个有序数组即可
     * */
    public static double findMedianSortedArray(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int medianIndexLeft = (m + n - 1) / 2;
        int medianIndexRight = (m + n) / 2;

        if (0 == nums1.length) {
            return (nums2[medianIndexLeft] + nums2[medianIndexRight]) * 0.5;
        } else if (0 == nums2.length) {
            return (nums1[medianIndexLeft] + nums1[medianIndexRight]) * 0.5;
        }

        int[] target = new int[medianIndexRight + 1];
        int num1Index = 0;
        int num2Index = 0;
        for (int i = 0; i < medianIndexRight + 1; i++) {

            if (num1Index >= m) {
                target[i] = nums2[num2Index++];
            } else if (num2Index >= n) {
                target[i] = nums1[num1Index++];
            } else if (nums1[num1Index] > nums2[num2Index]) {
                target[i] = nums2[num2Index++];
            } else {
                target[i] = nums1[num1Index++];
            }

        }

        return (target[medianIndexLeft] + target[medianIndexRight]) * 0.5;

    }

}
