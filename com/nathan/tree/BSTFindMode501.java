package com.nathan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTFindMode501 {
    /**
     * 二叉搜索树找众数
     * <p>
     * 中序遍历则相当于遍历有序数组，统计即可
     */
    public int[] findMode(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        int maxCount = 0;
        TreeNode pre = null;

        List<Integer> res = new ArrayList<>();
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (null == pre) {
                    count = 1;
                } else if (pre.val == root.val) {
                    count++;
                } else {
                    // 不相等重置计数器
                    count = 1;
                }

                if (count == maxCount) {
                    res.add(root.val);
                }
                if (count > maxCount) {
                    maxCount = count;
                    res.clear();
                    res.add(root.val);
                }

                pre = root;
                root = root.right;
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }
        return array;
    }
}
