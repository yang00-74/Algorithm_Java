package com.nathan.stack;

import com.nathan.list.ListNode;

import java.util.Stack;

public class TwoListAdded {

    /**
     * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (null != l1) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (null != l2) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode pre = null;
        int carry = 0;
        while (true) {
            int val = carry;
            if (!stack1.isEmpty()) {
                val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }
            carry = val / 10;
            ListNode node = new ListNode(val % 10);
            node.next = pre;
            pre = node;

            if (stack1.isEmpty() && stack2.isEmpty()) {
                break;
            }
        }
        // 最后产生了进位
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = pre;
            pre = node;
        }

        return pre;
    }
}
