package com.nathan.array;

public class FindKth {

    /**
     * 寻找数组中第 k 大的数，需根据快速排序的思路
     */
    public int findKth(int[] a, int left, int right, int k) {
        if (left <= right) {
            int index = partition(a, left, right);
            if (k - 1 == index) {
                return a[index];
            } else if (k - 1 < index) {
                return findKth(a, left, index - 1, k);
            } else {
                return findKth(a, index + 1, right, k);
            }
        }
        return -1;
    }

    public int partition(int[] a, int left, int right) {
        int cut = a[left];
        while (left < right) {
            // 降序
            while (left < right && a[right] <= cut) {
                right--;
            }
            swap(a, left, right);

            while (left < right && a[left] >= cut) {
                left++;
            }
            swap(a, left, right);
        }

        return left;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
