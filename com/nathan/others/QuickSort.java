package com.nathan.others;

import com.nathan.util.Util;

public class QuickSort {
    //快排
    public void quickSort(int a[], int left, int right) {
        int i, j;
        while (left < right) {
            i = left;
            j = right + 1;
            do {
                while (a[++i] < a[left]) ;
                while (a[--j] > a[left]) ;
                if (i < j) Util.swap(a, i, j);//从左往右找比标记元素大,从右往左找比标记元素小,交换
            } while (i < j);

            Util.swap(a, left, j);//一趟完毕，交换标记元素位置
            quickSort(a, left, j - 1);
            quickSort(a, j + 1, right);
            return;
        }
    }
}
