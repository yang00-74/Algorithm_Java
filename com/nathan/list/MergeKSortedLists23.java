package com.nathan.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists23 {
    /**
     * 维护当前每个链表没有被合并的元素的最前面一个，k 个链表就最多有 k 个满足这样条件的元素，每次在这些元素里面选取 val 属性最小的
     * 元素合并到答案中。在选取最小元素的时候，可以用优先队列来优化这个过程
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode root : lists) {
            if (null != root) {
                queue.offer(root);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            tail.next = min;
            tail = tail.next;
            if (null != min.next) {
                queue.offer(min.next);
            }
        }

        return dummyHead.next;
    }

    /**
     * 分治法，将链表两两合并
     *
     * */
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return mergeTwoList(leftNode, rightNode);
    }

    public ListNode mergeTwoList(ListNode leftNode, ListNode rightNode) {
        if (null == leftNode) {
            return rightNode;
        }
        if (null == rightNode) {
            return leftNode;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode root = dummyHead;
        while (null != leftNode && null != rightNode) {
            if (leftNode.val < rightNode.val) {
                root.next = leftNode;
                leftNode = leftNode.next;
            } else {
                root.next = rightNode;
                rightNode = rightNode.next;
            }
            root = root.next;

        }

        root.next = leftNode == null ? rightNode : leftNode;
        return dummyHead.next;
    }
}
