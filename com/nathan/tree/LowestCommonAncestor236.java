package com.nathan.tree;

public class LowestCommonAncestor236 {
    /**
     * 二叉树查找 两个节点的最近公共节点
     *
     * 1. 确定递归函数返回值以及参数
     * 需要递归函数返回值，来告诉我们是否找到节点q或者p，那么返回值为bool类型就可以了。
     * 但我们还要返回最近公共节点，可以利用上题目中返回值是TreeNode * ，那么如果遇到p或者q，就把q或者p返回，返回值不为空，就说明找到了q或者p
     *
     * 2. 确定终止条件
     * 如果找到了 节点p或者q，或者遇到空节点，就返回
     *
     * 3. 确定单层递归逻辑
     * 值得注意的是 本题函数有返回值，是因为回溯的过程需要递归函数的返回值做判断，但本题我们依然要遍历树的所有节点
     *
     * 在递归函数有返回值的情况下：如果要搜索一条边，递归函数返回值不为空的时候，立刻返回，如果搜索整个树，直接用一个变量left、right接住返回值，
     * 这个left、right后序还有逻辑处理的需要，也就是后序遍历中处理中间节点的逻辑（也是回溯）
     *
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) {
            return root;
        }
        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 根节点处理
        if (null != left && null != right) {
            return root;
        } else if (null == left) {
            return right;
        } else {
            return left;
        }
    }
}
