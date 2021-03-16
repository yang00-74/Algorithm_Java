package com.nathan.list;

public class IntersectionNode160 {
    /**
     * 找到两个单链表相交的起始节点
     *
     * 如下可知，如果有相交的结点D的话,每条链的头结点先走完自己的链表长度,然后回头走另外的一条链表,那么两结点一定为相交于D点,
     * 因为这时每个头结点走的距离是一样的:
     * len1a + len + len2b = len2b + len + len1a
     *
     *  list1: a-b-c-d-e-f-g
     *              /
     *  list2:   h-i
     *
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}
