package com.nathan.list;

public class MergeTwoSortedLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode p = null;
        if (l1.val > l2.val) {
            p = l2;
            p.next = mergeTwoLists(l1, l2.next);
        } else {
            p = l1;
            p.next = mergeTwoLists(l1.next, l2);
        }
        return p;
    }
}
