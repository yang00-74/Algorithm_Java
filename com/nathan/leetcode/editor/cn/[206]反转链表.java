package com.nathan.leetcode.editor.cn;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 3421 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.nathan.list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);

        node.next = node1;
        node1.next = node2;

        reverseList(node);
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        // 递归深入到链表最后一个元素，尾插法，此时 head 为 newRoot 前一个元素
        ListNode newRoot = reverseList(head.next);
        head.next.next = head;
        // 断链
        head.next = null;
        return newRoot;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
