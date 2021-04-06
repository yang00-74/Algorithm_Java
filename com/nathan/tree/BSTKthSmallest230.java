package com.nathan.tree;

import java.util.Stack;

public class BSTKthSmallest230 {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数
     *
     * 思路：二叉搜索树中序遍历为有序数组
     * */
    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                count++;
                if (count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }

}
