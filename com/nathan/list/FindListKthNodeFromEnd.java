package com.nathan.list;

public class FindListKthNodeFromEnd {

    /** 打印链表倒数第k个元素
     *
     * 剑指 Offer 22
     * */
    public ListNode findKthFromEnd(ListNode head, int k) {
        if (null == head || k < 0) {
            return null;
        }
        //两个指针都指向头结点
        ListNode ahead = head;
        ListNode follow = head;

        //记录节点总个数
        int count = 0;
        int n = k;
        //ahead 指针先跑，并且记录节点数，当 ahead 指针跑了k-1个节点后，follow指针开始跑，
        //当 ahead 指针跑到最后时，follow 所指就是倒数第k个节点
        while (ahead != null) {
            ahead = ahead.next;
            count++;
            if (k < 1) {
                follow = follow.next;
            }
            k--;
        }
        //如果节点总个数小于 K，则返回空
        if (count < n) {
            return null;
        }
        return follow;
    }
}
