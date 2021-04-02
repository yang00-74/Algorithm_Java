package com.nathan.backtracking;

import com.nathan.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {

    /**
     * 返回二叉树所有叶子节点到根节点组成的路径
     */
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        traversal2(root, new ArrayList<>());
        return res;
    }

    private void traversal2(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) sb.append(i).append("->");
            sb.append(root.val);
            res.add(sb.toString());
        } else {
            list.add(root.val);
            if (root.left != null)
                traversal2(root.left, list);
            if (root.right != null)
                traversal2(root.right, list);
            list.remove(list.size() - 1);
        }
    }
}
