package com.nathan.list;

public class FindListKthNodeFromEndToRemove19 {

    /**
     * 移除链表倒数第 k 个元素
     */
    public ListNode deleteKthFromEnd(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode former = dummy, latter = head;
        for (int i = 0; i < k + 1; i++) {
            if (null == former) {
                return null;
            }
            former = former.next;
        }
        // 可能移除头节点
        ListNode pre = dummy;
        while (former != null) {
            pre = latter;
            former = former.next;
            latter = latter.next;
        }

        pre.next = latter.next;
        return dummy.next;
    }
}
