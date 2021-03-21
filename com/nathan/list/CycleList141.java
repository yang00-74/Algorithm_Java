package com.nathan.list;

import org.junit.Test;

public class CycleList141 {

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        e.next = b;

        System.out.println(hasCycle(a));

    }

    /**
     * 给定一个链表，判断链表中是否有环
     *
     * 快慢指针
     * */
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            // 出现 null 则无环
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
