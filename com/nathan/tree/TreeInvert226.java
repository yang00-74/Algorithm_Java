package com.nathan.tree;

import java.util.Stack;

public class TreeInvert226 {

    public TreeNode invertTree2(TreeNode root) {
        if (null == root) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            TreeNode tmp = head.left;
            head.left = head.right;
            head.right = tmp;
            if (null != head.right) {
                stack.push(head.right);
            }
            if (null != head.left) {
                stack.push(head.left);
            }
        }

        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
