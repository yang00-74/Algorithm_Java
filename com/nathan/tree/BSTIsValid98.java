package com.nathan.tree;

import java.util.Stack;

public class BSTIsValid98 {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 中序遍历
     */
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (pre > root.val) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        if (null == root) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long preVal = Long.MIN_VALUE;
        while (!stack.isEmpty() || null != root) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (preVal >= node.val) {
                    return false;
                }
                preVal = node.val;
                root = node.right;
            }
        }
        return true;
    }
}
