package com.nathan.list;

import java.util.Stack;

public class ReversePrintList {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     *
     * 使用辅助栈
     * */
    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode pre = head;
        while (pre != null) {
            stack.push(pre.val);
            pre = pre.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop();
        }
        return print;
    }
}
