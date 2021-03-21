package com.nathan.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue513 {
    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值
     */
    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
