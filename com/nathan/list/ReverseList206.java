package com.nathan.list;

public class ReverseList206 {
    /**
     * leet code 206 双指针，反转链表
     *
     *定义两个指针： pre 和 cur , pre 在前 cur 在后。
     * 每次让 pre 的 next 指向 cur ，实现一次局部反转
     * 局部反转完成之后， pre 和 cur 同时往前移动一个位置
     * 循环上述过程，直至 pre 到达链表尾部
     *
     * */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur = null;
        ListNode pre = head;
        ListNode next;
        while (pre != null) {
            next = pre.next;
            pre.next = cur;

            cur = pre;
            pre = next;
        }
        return cur;
    }
}
