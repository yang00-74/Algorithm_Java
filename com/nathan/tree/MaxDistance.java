package com.nathan.tree;

public class MaxDistance {

    /**
     * 获取二叉树中两个子节点相距最大距离,可转换为二叉树两子树高度之和的问题
     * Note:根节点两子树高度之和并不一定等于两个子节点相距最大距离,存在相距最远的两子节点在根节点同一子树下的情况,故需变量 max 记录该值
     *  a                                               a
     * / \                                             / \
     * b  c (根节点子树高度之和 = 子节点相距最大距离)          b   c
     *                                               / \
     *                                              d   e
     *                                              /    \
     *                                             f     g (根节点子树高度之和 < 子节点相距最大距离)
     *                                            /       \
     *                                           h        j
     *
     * @return max 全局变量记录最大距离
     */

    static int max = 0;
    public int maxDistanceOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }

    //获取树高
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        // 全局变量记录最大距离
        max = Math.max(max, left + right);

        return (left > right) ? left + 1 : right + 1;
    }
}
