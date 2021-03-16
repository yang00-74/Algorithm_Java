package com.nathan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     *
     * 借助队列实现
     * */
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (null != node.left) {
                queue.add(node.left);
            }
            if (null != node.right) {
                queue.add(node.right);
            }
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            res[index++] = i;
        }
        return res;
    }

}
