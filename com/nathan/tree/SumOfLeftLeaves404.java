package com.nathan.tree;

import java.util.Stack;

public class SumOfLeftLeaves404 {
    /**
     * 二叉树左叶子之和
     *
     * 判断左叶子的条件：通过当前节点的父节点进行判断。如果父节点的左节点不为空，且这个左节点没有左右孩子，那么这个节点就是左叶子
     * */
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node.left && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
