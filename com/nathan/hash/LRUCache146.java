package com.nathan.hash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {


    public static void main(String[] args) {
        LRUCache146 cache146 = new LRUCache146(2);

        cache146.put(1, 1);
        cache146.put(2, 2);
        cache146.get(1);
        cache146.put(3, 3);

        System.out.println(cache146.get(2));
    }

    /**
     * HashMap 实现 O(1) 查找
     * <p>
     * 双向链表维护访问关系，最近访问的移动到链表尾部，链表头即为最近最少使用的
     */
    private Integer capacity;

    private int size;

    private LinkedNode head, tail;

    private Map<Integer, LinkedNode> cache;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        cache = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，因为访问过了，需将其移动到尾部
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        // 不存在则新建节点
        if (node == null) {
            if (size == capacity) {
                // 删除头节点的 next 节点
                LinkedNode header = removeNode(head.next);
                cache.remove(header.key);
                size--;
            }

            node = new LinkedNode(key, value);
            cache.put(key, node);
            addToTail(node);
            size++;
        } else {
            // 存在则需要先将其从双向链表中移除，再移动节点到尾部
            node.value = value;
            moveToTail(node);
        }
    }

    private void addToTail(LinkedNode node) {
        LinkedNode pre = tail.prev;

        tail.prev = node;
        node.next = tail;

        pre.next = node;
        node.prev = pre;
    }

    private void moveToTail(LinkedNode node) {
        removeNode(node);
        addToTail(node);
    }

    private LinkedNode removeNode(LinkedNode node) {
        LinkedNode pre = node.prev;
        LinkedNode next = node.next;

        pre.next = next;
        next.prev = pre;

        return node;
    }


    static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
