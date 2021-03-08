package com.nathan.array;

import java.util.LinkedList;

public class SlideWindow {
    public static void main(String[] args) {
        int a[] = {1, 3, -1, -3, 0, 5, 3, 6, 7};
        int size = 3;
        int[] res = new SlideWindow().maxInWindows(a, 3);
    }

    /**
     * 长度为 n 的窗口在数组上滑动，窗口每次移动一格，输出每次移动前窗口中的最大数字
     * <p>
     * 利用双端队列记录当前滑动窗口的元素索引，队列最左侧元素记录滑动窗口中最大元素的索引
     * 遍历数组：
     * 1. 如果队列最左侧索引已不在滑动窗口范围内，弹出队列最左侧索引
     * 2. 通过循环确保队列的最左侧索引所对应元素值最大
     * 3. 新元素入队
     * 4. 从第一个滑动窗口的末尾索引开始将最大值存储到结果res中
     */
    public int[] maxInWindows(int[] nums, int k) {

        if (1 >= nums.length || k <= 1) {
            return nums;
        }

        // 双向队列 保存当前窗口的数组下标，保证窗口中最大的元素的数组下标在队列头
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 更新窗口，将左边的无效下标去除
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // 从右侧开始比较，将小于遍历元素的下标弹出，确保最左侧索引所对应元素值最大
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return res;

    }
}
