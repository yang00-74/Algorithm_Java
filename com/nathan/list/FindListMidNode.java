package com.nathan.list;

import java.util.Objects;

public class FindListMidNode {

    /**
     * 一次遍历访问链表中间节点
     *
     * 思路:
     * 快慢指针, 快指针每次走 2 步, 慢指针每次走1步,当快指针到达链表尾部时,慢指针到达链表中部
     */
    public ListNode findMidNode(ListNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        ListNode slow = root;
        ListNode fast = root;
        while (null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (null == fast) {
                break;
            }
        }
        return slow;
    }
}
