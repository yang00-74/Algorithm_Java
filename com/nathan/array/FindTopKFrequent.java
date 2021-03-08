package com.nathan.array;

import org.junit.Test;

import java.util.*;

public class FindTopKFrequent {


    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 5, 6, 7};
        System.out.println(new FindTopKFrequent().topKFrequent(nums, 4));
    }

    /**
     * leet code 347
     * 返回一个数组中出现频率最高的 k 个元素
     *
     * */
    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(counterMap::get));

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else {
                if (entry.getValue() > counterMap.get(queue.peek())) {
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
