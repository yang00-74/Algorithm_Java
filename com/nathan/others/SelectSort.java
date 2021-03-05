package com.nathan.others;

import static com.nathan.util.Util.swap;

public class SelectSort {

    //选择排序，每次选择最小值放到数组已排序的末尾
    public void selectSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(a, minIndex, i);
            }
        }
    }
}
