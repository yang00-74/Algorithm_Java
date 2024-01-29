package com.nathan.leetcode.editor.cn;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 2743 👎 0


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
class Solution19 {
    /**
     * 假如链表总长为 m，则倒数第 n 个节点即为顺数 m - (n - 1) 个节点
     * 存在 3 种情况：
     * 1.移除头节点
     * 2.移除中间节点
     * 3.移除尾部节点
     *
     * 使用两个指针:
     * 快指针指向 head，慢指针指向 head 的前一个 dummy 节点
     * 先走 n - 1 步，慢指针再开始移动，直到快指针到达链表尾部
     *
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return head;
        ListNode fast = head;
        for (int i = 0; i < n - 1; i ++) {
            fast = fast.next;
            if (null == fast) {
                return null;
            }
        }
        // 可能移除头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = dummy;
        while (null != fast) {
            // 保留慢指针前一个节点
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
