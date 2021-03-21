package com.nathan.queue;

import java.util.PriorityQueue;

/**
 *  数据流的中位数
 * */
class MedianFinderFromStream295 {

    private PriorityQueue<Integer> hiHeap;

    private PriorityQueue<Integer> lowHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinderFromStream295() {
        // 小顶堆，存储大的那一半元素，堆顶为最小值
        hiHeap = new PriorityQueue<>();
        // 大顶堆，存储小的那一半元素，堆顶为最大值
        lowHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        hiHeap.offer(num);
        lowHeap.offer(hiHeap.poll());
        if (lowHeap.size() > hiHeap.size() + 1) {
            hiHeap.offer(lowHeap.poll());
        }
    }

    public double findMedian() {
        if (hiHeap.size() == lowHeap.size()) {
            return (double) (hiHeap.peek() + lowHeap.peek()) * 0.5;
        }
        return (double) lowHeap.peek();
    }
}
