package com.nathan.leetcode.editor.cn;/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (76.36%)
 * Likes:    1140
 * Dislikes: 0
 * Total Accepted:    717.1K
 * Total Submissions: 938.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start

import com.nathan.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Stack<TreeNode> front = new Stack<>();
        Stack<TreeNode> back = new Stack<>();
        front.push(root);
        while (!front.isEmpty()) {
            TreeNode node = front.pop();
            back.push(node);
            if (null != node.left) {
                front.push(node.left);
            }
            if (null != node.right) {
                front.push(node.right);
            }
        }
        while (!back.isEmpty()) {
            list.add(back.pop().val);
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        List<Integer> left = postorderTraversal2(root.left);
        List<Integer> right = postorderTraversal2(root.right);

        list.addAll(left);
        list.addAll(right);
        list.add(root.val);
        return list;
    }
}
// @lc code=end

