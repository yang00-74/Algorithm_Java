package com.nathan.leetcode.editor.cn;
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 
// 👍 1221 👎 0


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
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode ahead = new ListNode(0, head);
        ListNode cur = ahead;
        // 当前节点后两个节点不为 null
        while (null != cur.next && null != cur.next.next) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                // 确定了一个重复值
                int tmp = cur.next.val;
                // 已经排序的链表检查其后的值
                while (null != cur.next && cur.next.val == tmp) {
                    // 相同值节点消除
                    cur.next = cur.next.next;
                }
            }
        }
        return ahead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
