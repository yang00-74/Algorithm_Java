package com.nathan.tree;

public class IsSubtree572 {
    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
     * s 也可以看做它自身的一棵子树。
     *
     * 思路：先序遍历
     * */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        //当Tree1和Tree2都不为null的时候，才进行比较。否则直接返回false
        if (t != null && s != null) {
            if (s.val == t.val) {
                //如果根相同，以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(s, t);
            }
            //如果根不同，那么就再去root的左儿子当作起点，去判断是否包含Tree2
            if (!result) {
                result = isSubtree(s.left, t);
            }
            //如果还找不到，那么就再将root的右儿子当作起点，去判断是否包含Tree2
            if (!result) {
                result = isSubtree(s.right, t);
            }
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return null == node1;
        }
        if (node1 == null || node1.val != node2.val) {
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}
