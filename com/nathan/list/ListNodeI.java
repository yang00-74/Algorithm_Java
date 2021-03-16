package com.nathan.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义实现链表
 */

public class ListNodeI {
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        ListNode slow = a;
        ListNode fast = a;
        ListNode mid = null;
        while (null != fast && null != fast.next) {
            mid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // 从链表中间位置将其后的节点断开
        mid.next = null;

        while (null != a) {
            System.out.println(a.val);
            a = a.next;
        }

        while (null != slow) {
            System.out.println(slow.val);
            slow = slow.next;
        }

    }

    //链表元素出现重复就删除
    public ListNode deleteDuplication2(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);//index比pHead多一个结点，遍历时可在pHead出现相同的前一节点停住，从而错开
        index.next = pHead;

        result = index;//记住index链表的头结点
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                while (temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                index.next = temp;//处理index链表
            } else {
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;

    }

    //链表复制
    public ListNode Clone(ListNode pHead) {
        if (pHead == null) return null;
        ListNode p = new ListNode(pHead.val);
        p.next = pHead.next;

        p.next = Clone(pHead.next);

        return p;
    }

    //去掉链表中重复的元素
    public ListNode deleteDuplication(ListNode pHead) {
        while (pHead != null) {
            ListNode N = new ListNode(0);
            if (pHead.next == null) return pHead;

            N = pHead.next;
            while (pHead.val == N.val) {//判断结点是否有连续相等
                N = N.next;
            }
            pHead.next = N;
            pHead = pHead.next;
        }
        return pHead;
    }

    //求带环链表的入口
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode p = pHead;
        ListNode q = pHead;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                q = pHead;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode cur = head;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        head = cur;
        for (int i = 0; i < list.size(); i++) {
            head.val = list.get(i);
            head = head.next;
        }
        return cur;

    }

}
