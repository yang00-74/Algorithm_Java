package com.nathan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal144 {
    /**
     * 二叉树先序遍历
     */
    public List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (null != node.right) {
                stack.add(node.right);
            }
            if (null != node.left) {
                stack.add(node.left);
            }
        }
        return res;
    }


    public List<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        res.add(root.val);
        List<Integer> left = preOrderTraversal(root.left);
        List<Integer> right = preOrderTraversal(root.right);

        res.addAll(left);
        res.addAll(right);
        return res;
    }
}
