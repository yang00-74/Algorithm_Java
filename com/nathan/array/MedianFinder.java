package com.nathan.array;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> hiHeap;

    private PriorityQueue<Integer> lowHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        hiHeap = new PriorityQueue<>();
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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
