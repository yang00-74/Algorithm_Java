package com.nathan.others;

import static com.nathan.util.Util.swap;

public class HeapSort {

    public static void main(String[] args) {
        int a[] = {2, 5, 8, 9, 10, 45, 56, 78};
		new HeapSort().heapSort(a,  10);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void heapAdjust(int a[], int i, int size) {
        //从a[i]向下调整堆
        int left_child = 2 * i + 1;
        int right_child = 2 * i + 2;
        int max = i;
        //找父节点和两个子节点中的最大值，确保父节点为最大值
        if (left_child < size && a[left_child] > a[max])
            max = left_child;
        if (right_child < size && a[right_child] > a[max])
            max = right_child;
        if (max != i) {
            swap(a, i, max);
            //记录交换前子节点位置，从该位置向下调整堆
            heapAdjust(a, max, size);
        }
    }

    //建最大堆
    public int buildHeap(int a[], int n) {
        int heapSize = n;
        //从非叶子结点开始调整，直到a[0]根
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, heapSize);
        }
        return heapSize;
    }

    //堆排序
    public void heapSort(int a[], int n) {
        int heap_size = buildHeap(a, n);
        while (heap_size > 1) {
            // 将堆顶元素与堆的最后一个元素互换，并将最后一个元素从以后的堆调整中忽略--heap_size
            swap(a, 0, --heap_size);
            //从新的堆顶调整堆
            heapAdjust(a, 0, heap_size);
        }
    }
}
