package com.nathan.tree;

public class MergeTrees617 {

    /**
     * 合并二叉树
     *
     * 1.确定递归函数的参数和返回值：
     * 首先那么要合入两个二叉树，那么参数至少是要传入两个二叉树的根节点，返回值就是合并之后二叉树的根节点
     *
     * 2. 确定终止条件：
     * 因为是传入了两个树，那么就有两个树遍历的节点t1 和 t2，如果t1 == NULL 了，两个树合并就应该是 t2 了啊（如果t2也为NULL也无所谓，合并之后就是NULL）。
     *
     * 反过来如果t2 == NULL，那么两个数合并就是t1（如果t1也为NULL也无所谓，合并之后就是NULL）。
     *
     * 3. 确定单层递归的逻辑：
     *
     * 单层递归中，就要把两棵树的元素加到一起，形成合并树节点
     * 接下来合并树的左子树是：合并 t1左子树 t2左子树之后的左子树。
     *
     * 合并树的右子树：是 合并 t1右子树 t2右子树之后的右子树。
     *
     * 最终合并树节点就是合并之后的根节点
     * */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) return root2;
        if (null == root2) return root1;
        // 新建树节点
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
}
