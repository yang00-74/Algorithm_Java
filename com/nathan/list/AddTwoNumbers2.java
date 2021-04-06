package com.nathan.list;

import com.nathan.list.ListNode;

public class AddTwoNumbers2 {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表
     *
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (true) {
            int val = carry;
            if (null != l1) {
                val += l1.val;
                l1 = l1.next;
            }

            if (null != l2) {
                val += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            current.next = node;
            current = current.next;
            if (null == l1 && null == l2) {
                break;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
