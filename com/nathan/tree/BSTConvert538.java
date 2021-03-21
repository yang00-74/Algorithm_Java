package com.nathan.tree;

import java.util.Stack;

public class BSTConvert538 {
    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
     * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和
     *
     * 中序遍历逆转，从右子树开始累加
     * */
    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = root;
        TreeNode pre = null;
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                if (null != pre) {
                    root.val += pre.val;
                }
                pre = root;
                root = root.left;
            }
        }
        return dummy;
    }
}
