package com.nathan.queue;

import java.util.PriorityQueue;

public class MedianOfArray {
    /**
     * 无序数组找中位数
     */
    public double median(int[] array) {
        int size = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            if (heap.size() >= size) {
                heap.poll();
            }
            heap.add(array[i]);
        }
        if ((array.length & 1) == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }
}
