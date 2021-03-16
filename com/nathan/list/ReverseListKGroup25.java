package com.nathan.list;

public class ReverseListKGroup25 {

    /**
     * 每 k 个节点一组进行翻转，返回翻转后的链表
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = pre;
        while (null != end.next) {
            for (int i = 0; i < k && null != end; i++) {
                // 后移确定翻转链表右边界
                end = end.next;
            }
            if (null == end) {
                break;
            }

            // 保存翻转的左边界
            ListNode left = pre.next;
            // 保存右边界后面的链表
            ListNode rightNext = end.next;
            // 从右边界处断链
            end.next = null;
            // 逆转链表
            pre.next = reverse(left);
            // 左边界逆转后成为右边界，续上链表
            left.next = rightNext;

            // 头指针移动到左边界逆转后的节点处，继续循环
            pre = left;
            end = pre;

        }
        return dummy.next;
    }

    public ListNode reverse(ListNode root) {
        if (null == root) {
            return root;
        }
        ListNode pre = null;
        while (null != root) {
            ListNode temp = root.next;
            root.next = pre;
            pre = root;
            root = temp;
        }

        return pre;
    }
}
