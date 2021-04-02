package com.nathan.tree;

import java.util.Stack;

public class BSTMinimumDifference530 {

    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
     *
     * 二叉搜索树中序遍历为有序的数组，比较即可
     * */
    public int getMinimumDifference(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (null != pre) {
                    min = Math.min(min, root.val - pre.val);
                }
                pre = root;
                root = root.right;
            }
        }
        return min;
    }
}
