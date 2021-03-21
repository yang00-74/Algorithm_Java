package com.nathan.tree;

public class BSTTrim669 {
    /**
     * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
     * 修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (null == root) {
            return root;
        }
        // 越过范围，节点值比下限小，则从其右节点找
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 越过范围，节点值比上限大，则从其左节点找
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 在范围内处理
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


}
