package com.nathan.list;

import java.util.Objects;

public class SortList148 {

    /**
     * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
     */
    public ListNode sortList(ListNode head) {
        return null == head ? null : mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (Objects.isNull(head.next)) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;
        while (null != fast && null != fast.next) {
            mid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // mid.next == slow, 从链表中间位置将其后的节点断开
        mid.next = null;

        ListNode node1 = mergeSort(head);
        ListNode node2 = mergeSort(slow);
        return mergeTwoLists(node1, node2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = null == l1 ? l2 : l1;
        return dummyHead.next;
    }
}
