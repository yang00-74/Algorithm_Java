package com.nathan.others;

import static com.nathan.util.Util.swap;

public class BubbleSort {

    // 冒泡排序，最好时间为 O（n）,最大的冒到数组末尾
    public void bubbleSort(int a[]) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }
}
