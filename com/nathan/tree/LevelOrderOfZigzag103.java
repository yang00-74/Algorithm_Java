package com.nathan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderOfZigzag103 {
    /**
     * 之字形打印二叉树
     * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }

                if ((levelCount & 1) == 1) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
            }
            levelCount++;
            res.add(level);
        }

        return res;
    }

}
