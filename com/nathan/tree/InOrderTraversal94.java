package com.nathan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal94 {

    /**
     * 中序遍历二叉树,先将左节点压入栈,当节点为 null,栈顶元素出栈,遍历出栈元素的右节点
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }

        return res;
    }
}
