package com.nathan.tree;

public class CountNodes222 {
    /**
     * 给定一棵 完全二叉树 的根节点 root ，求出该树的节点个数
     */
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }
}
