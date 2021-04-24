package com.nathan.tree;

import java.util.HashMap;
import java.util.Map;

public class ReBuildTree {

    /**
     * 剑指 Offer 07. 重建二叉树
     * 根据先序遍历和中序遍历重建二叉树
     *  假设不存在重复元素
     *
     * 先序遍历的第一个元素即为树的根节点，
     * 则使用这个元素可以将中序遍历数组分割为左子树和右子树两个部分，此时再根据中序遍历左子树长度
     * 亦可以将先序遍历数组划分为左右子树
     *
     * 递归以上过程即可
     * */
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        pre = preorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = pre[preStart];
        TreeNode root = new TreeNode(val);

        int inorderPartition = inorderMap.get(val);

        root.left = buildTree(preStart + 1, preStart + inorderPartition - inStart,
                inStart, inorderPartition - 1);
        root.right = buildTree(preStart + 1 + inorderPartition - inStart, preEnd,
                inorderPartition + 1, inEnd);
        return root;
    }

}
