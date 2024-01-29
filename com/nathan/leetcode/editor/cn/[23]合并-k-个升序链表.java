package com.nathan.leetcode.editor.cn;
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (58.80%)
 * Likes:    2738
 * Dislikes: 0
 * Total Accepted:    747.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * 示例 2：
 * 
 * 输入：lists = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：lists = [[]]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
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
class Solution23 {
    /**
     * 分治法
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, Integer left, Integer right) {
        if (left.equals(right)) {
            return lists[right];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        // 递归深入，一直找到一个符合要求的链表头节点为止
        ListNode root1 = partition(lists, left, mid);
        ListNode root2 = partition(lists, mid + 1, right);
        return merge(root1, root2);
    }


    private ListNode merge(ListNode root1, ListNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }
        ListNode head;
        if (root1.val > root2.val) {
            head = root1;
            head.next = merge(root1.next, root2);
        } else {
            head = root2;
            head.next = merge(root1, root2.next);
        }
        return head;
    }
}
// @lc code=end

