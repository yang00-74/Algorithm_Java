package com.nathan.list;

public class PalindromeList234 {
    /**
     *判断一个链表是否为回文链表
     *
     * 思路1：将链表居中断开，再逆转其中一部分，从头开始比较
     * 思路2：栈辅助
     * */
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        // 快慢指针找中间节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode cut = null;
        while (null != fast && null != fast.next) {
            cut = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // 断开链表
        cut.next = null;

        // 逆置链表左半段
        ListNode pre = null;
        ListNode current = head;
        while (null != current) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        // 链表节点数为奇数，则右半段节点移动一位
        if (null != fast) {
            slow = slow.next;
        }

        while (null != pre) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
