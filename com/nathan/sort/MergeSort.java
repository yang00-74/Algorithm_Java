package com.nathan.sort;

public class MergeSort {

    //归并排序
    public void merge(int[] a, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int index = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            temp[index++] = a[i] <= a[j] ? a[i++] : a[j++];
        }//左右两部分长度不一样时的处理
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }
        for (int k = 0; k < len; k++) {
            a[left++] = temp[k];//把排序好的数组赋值给原数组
        }
    }

    public void mergeSort(int[] a, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;//把数组分划
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        merge(a, left, mid, right);//归并数组

    }
}
