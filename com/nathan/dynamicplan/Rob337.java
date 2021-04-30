package com.nathan.dynamicplan;

import com.nathan.tree.TreeNode;

public class Rob337 {

    /**
     * 1. dp数组（dp table）以及下标的含义
     * 下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱
     *
     * 2. 确定终止条件
     * 在遍历的过程中，如果遇到空节点的话，很明显，无论偷还是不偷都是0，所以就返回
     *
     * 3. 确定遍历顺序
     * 首先明确的是使用后序遍历。因为通过递归函数的返回值来做下一步计算。
     *
     * 通过递归左节点，得到左节点偷与不偷的金钱。
     *
     * 通过递归右节点，得到右节点偷与不偷的金钱。
     *
     * 4. 确定单层递归的逻辑
     * 如果是偷当前节点，那么左右孩子就不能偷
     * 如果不偷当前节点，那么左右孩子就可以偷，至于到底偷不偷一定是选一个最大的
     *
     * 最后当前节点的状态就是{val1, val2}; 即：{不偷当前节点得到的最大金钱，偷当前节点得到的最大金钱}
     *
     * */
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode root) {
        if (null == root) {
            return new int[]{0, 0};
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        // 不偷当前节点，则取左右子树最大值相加
        int val1 = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        // 偷当前节点，则其左右节点不可偷
        int val2 = root.val + left[0] + right[0];

        return new int[]{val1, val2};
    }
}
