package com.nathan.others;

public class InsertSort {

    //插入排序，类似抓牌排序
    public void insertSort(int a[]) {
        for (int i = 0;i <a.length;i++) {
            int get = a[i]; // 默认 a[0]为排序好的元素
            int j = i-1;
            while (j >= 0 && a[j] >get) {// a[i] 需要往有序序列插入，序列中大于 get 的元素需往后移动，挪出位置
                a[j+1]= a[j];
                j--;
            }
            a[j+1] = get;
        }
    }
}
