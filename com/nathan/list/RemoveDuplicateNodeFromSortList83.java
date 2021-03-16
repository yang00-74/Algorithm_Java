package com.nathan.list;

public class RemoveDuplicateNodeFromSortList83 {

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
     * */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (null != cur && null != cur.next) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
