package com.nathan.list;

public class MergeListInBetween1669 {

    /**
     * 给定两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置
     *
     * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
     *
     * */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null;
        ListNode end = null;
        int count = 0;
        ListNode head = list1;
        while (null != list1) {
            if (a - 1 == count) {
                start = list1;
            }
            list1 = list1.next;
            count++;
            if (b + 1 == count) {
                end = list1;
            }
        }
        if (null == list2) {
            start.next = end;
            return head;
        }
        ListNode second = list2;
        start.next = second;

        while (null != list2.next) {
            list2 = list2.next;
        }
        list2.next = end;

        return head;
    }

}
