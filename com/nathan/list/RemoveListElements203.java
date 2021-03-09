package com.nathan.list;

public class RemoveListElements203 {

    /**
     * 给定一个链表的头节点 head 和一个整数 val ，删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
     * */
    public ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟头结点
        ListNode pre = new ListNode(0);
        // 将虚拟头结点 next 指向head，方面后面做删除操作
        pre.next = head;
        ListNode current = pre;
        while (null != current.next) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return pre.next;
    }
}
