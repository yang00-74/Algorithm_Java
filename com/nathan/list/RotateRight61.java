package com.nathan.list;

public class RotateRight61 {

    /**
     * 右旋链表，将链表每个节点向右移动 k 个位置
     *
     * 首先计算出链表中的节点个数 count，然后计算 m = k % count：若值为 0，则表示将当前链表的每个节点向右移动 k 个位置后仍为当前链表，
     * 直接返回 head 即可；
     *
     * 若值不为 0，首先将链表首尾相连 p.next = head（因为在上面计算链表中节点个数时，p 指针已经指向链表的末尾了），
     * 然后令从右边数第 k 个节点为新的头节点，第 k + 1 个节点为新链表中最后一个节点即可
     *
     * */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int count = 1;
        while (p.next != null) {
            p = p.next;
            count++;
        }

        int m = k % count;
        if (m == 0) return head;

        // 将链表首尾相连
        p.next = head;
        // 找到倒数节点的前一个节点
        for (int i = 0; i < count - m; i++) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        return newHead;
    }
}
