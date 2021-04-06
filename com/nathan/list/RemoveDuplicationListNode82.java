package com.nathan.list;

public class RemoveDuplicationListNode82 {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * 双指针，pre 指向 current 的前一个节点，current 节点从头节点往后遍历
     * */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;

        ListNode current = pHead;
        ListNode pre = dummy;
        while (current != null) {
            if (current.next != null && current.next.val == current.val) {
                while (current.next != null && current.next.val == current.val) {
                    current = current.next;
                }
                // 再后移一步，将重复节点完全去除
                current = current.next;
                pre.next = current;
            } else {
                pre = pre.next;
                current = current.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (null != cur.next && null != cur.next.next) {
            // 确定了 cur 的下一个节点与下下个节点相等
            if (cur.next.val == cur.next.next.val) {
                // 取 cur 的下一个节点值为锚定
                int t = cur.next.val;
                while (null != cur.next && cur.next.val == t) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
