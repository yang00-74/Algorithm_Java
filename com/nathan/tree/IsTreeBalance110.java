package com.nathan.tree;

public class IsTreeBalance110 {

    // 判断二叉树是否平衡（左右子树高度之差小于等于1）
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        // 左右子树最大高度相减
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 自顶向下
     * */
    public int getHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 自底向上
     * */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
