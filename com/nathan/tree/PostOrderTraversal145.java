package com.nathan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal145 {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> back = new Stack<>();

        current.push(root);
        while (!current.isEmpty()) {
            TreeNode node = current.pop();
            back.push(node);

            if (null != node.left) {
                current.push(node.left);
            }
            if (null != node.right) {
                current.push(node.right);
            }
        }
        while (!back.isEmpty()) {
            res.add(back.pop().val);
        }
        return res;
    }
}
