package com.nathan.list;

public class ReverseList92 {

    /**
     * 给定单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right ，反转从位置 left 到位置 right 的链表节点，
     * 返回 反转后的链表
     *
     * */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (left > 1 && null != pre.next) {
            pre = pre.next;
            left--;
        }
        // 逆转开始的节点
        ListNode start = pre.next;

        while (right > 0 && null != end.next) {
            end = end.next;
            right--;
        }
        // 最后一部分节点
        ListNode last = end.next;
        // 断链
        end.next = null;

        ListNode p = null;
        ListNode tail = start;
        while (null != start) {
            ListNode tmp = start.next;
            start.next = p;
            p = start;
            start = tmp;
        }

        // 合链
        pre.next = p;
        tail.next = last;
        return dummy.next;
    }
}
