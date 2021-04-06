package com.nathan.hash;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache460 {

    /**
     * HashMap 实现 O(1) 查找
     * <p>
     * 维护一个 频次的 Map，key 为频次，value 为该频次对应的节点的集合
     */
    private Integer capacity;

    private int size;

    // 存储当前最小频次
    private int min;

    // 实际存储元素的 map
    private Map<Integer, LinkedNode> cache;

    // 维护 key 为频次，value 为该频次对应的节点的集合的 map
    private Map<Integer, LinkedHashSet<LinkedNode>> freqMap;

    public LFUCache460(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (null == node) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (0 == capacity) {
            return;
        }
        LinkedNode node = cache.get(key);
        if (null == node) {
            // 提前淘汰数据留下空间，如果先添加数据再淘汰可能会把新加入的元素（频次1）直接淘汰掉了
            if (size == capacity) {
                LinkedNode oldestNode = removeOldestNode();
                cache.remove(oldestNode.key);
                size--;
            }

            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addNewNode(newNode);
            size++;
        } else {
            node.value = value;
            freqInc(node);
        }
    }

    private LinkedNode removeOldestNode() {
        // 取访问频次最低的链表
        LinkedHashSet<LinkedNode> set = freqMap.get(min);
        // 从头遍历的第一个节点即为最旧的
        LinkedNode oldest = set.iterator().next();
        set.remove(oldest);
        return oldest;
    }

    private void addNewNode(LinkedNode node) {
        LinkedHashSet<LinkedNode> set = freqMap.computeIfAbsent(node.frequent, k -> new LinkedHashSet<>());
        set.add(node);
        // 新加入了节点则更新最小频次
        min = 1;
    }

    private void freqInc(LinkedNode node) {
        int frequent = node.frequent;
        // 从旧频次链表中将其移除
        LinkedHashSet<LinkedNode> oldSet = freqMap.get(frequent);
        oldSet.remove(node);
        // 更新最小频次
        if (frequent == min && oldSet.size() == 0) {
            min = frequent + 1;
        }

        // 频次自增，将节点添加到新的频次链表中
        LinkedHashSet<LinkedNode> newSet = freqMap.computeIfAbsent(frequent + 1, k -> new LinkedHashSet<>());
        node.frequent++;
        newSet.add(node);
    }

    static class LinkedNode {
        int key;
        int value;
        int frequent = 1;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
