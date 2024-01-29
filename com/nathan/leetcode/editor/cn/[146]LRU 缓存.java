package com.nathan.leetcode.editor.cn;
//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 3031 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Integer size;

    private Node tail;

    private Node head;

    private Integer capacity;

    private Map<Integer, Node> table;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new HashMap<>(capacity);

        this.tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = table.get(key);
        if (null == node) {
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    // 节点移动，首先需求将其从链表中去除，再添加到链表尾部
    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void addToTail(Node node) {
        Node pre = tail.pre;
        node.pre = pre;
        pre.next = node;

        node.next = tail;
        tail.pre = node;
    }

    public void put(int key, int value) {
        Node node = table.get(key);
        if (null != node) {
            node.value = value;
            moveToTail(node);
        } else {
            // 如果容量超了，要从 head 开始移除节点
            if (size >= capacity) {
                Node removed = head.next;
                removeNode(removed);
                table.remove(removed.key);
                size--;
            }
            node = new Node(key, value);
            size++;
            table.put(key, node);
            addToTail(node);
        }
    }


    static class Node {
        Node next;
        Node pre;
        Integer value;
        Integer key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
