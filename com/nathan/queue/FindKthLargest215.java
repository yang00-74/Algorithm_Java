package com.nathan.queue;

import java.util.PriorityQueue;

public class FindKthLargest215 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
     *
     * 采用优先权队列，小顶堆
     * **/
    public int findKthLargest(int[] nums, int k) {
        if (k < 0 || nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

}
