package com.nathan.leetcode.editor.cn;
/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
 *
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 *
 * algorithms
 * Easy (70.56%)
 * Likes:    972
 * Dislikes: 0
 * Total Accepted:    435.3K
 * Total Submissions: 616.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 
 * 如果有两个中间结点，则返回第二个中间结点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start

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
class Solution876 {
    /**
     * 快慢指针，fast 走 2 步，slow 走 1 步
     */
    public ListNode middleNode(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (null == fast || null == fast.next) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
// @lc code=end

