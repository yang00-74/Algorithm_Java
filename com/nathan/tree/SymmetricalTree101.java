package com.nathan.tree;

import java.util.Objects;

public class SymmetricalTree101 {

    /**
     * leet code 101
     *
     * */
    public boolean isSymmetrical(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return compareNode(root.left, root.right);
    }

    private boolean compareNode(TreeNode left, TreeNode right) {
        if (Objects.isNull(left)) {
            return Objects.isNull(right);
        }
        if (Objects.isNull(right)) {
            return false;
        }
        if (!Objects.equals(left.val, right.val)) {
            return false;
        }
        return compareNode(left.left, right.right) && compareNode(left.right, right.left);
    }
}
