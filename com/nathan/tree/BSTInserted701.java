package com.nathan.tree;

public class BSTInserted701 {
    /**
     *
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。返回插入后二叉搜索树的根节点。
     * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同
     *
     * 迭代法遍历, 过程中需要记录一下当前遍历的节点的父节点，这样才能做插入节点的操作
     * */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (null != cur) {
            parent = cur;
            if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val > val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }
}
