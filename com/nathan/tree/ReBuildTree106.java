package com.nathan.tree;

import java.util.HashMap;
import java.util.Map;

public class ReBuildTree106 {

    /**
     * 根据中序遍历和后序遍历重建二叉树
     * 假设不存在重复元素
     *
     * 后序遍历的最后一个元素即为树的根节点，
     * 则使用这个元素可以将中序遍历数组分割为左子树和右子树两个部分，此时再根据中序遍历左子树长度
     * 亦可以将后序遍历数组划分为左右子树
     *
     * 递归以上过程即可
     * */
    private Map<Integer, Integer> inOrderMap = new HashMap<>();
    private int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        post = postorder;
        return buildTree(0, inorder.length - 1, 0, post.length - 1);
    }

    private TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {

        if (inEnd < inStart || postEnd < postStart) {
            return null;
        }

        // 取后序遍历数组最后一个节点作为根节点
        int val = post[postEnd];
        int inorderPartitionIndex = inOrderMap.get(val);

        TreeNode root = new TreeNode(val);
        // 划分数组，中序数组的左子树下标范围为 inStart, inorderPartitionIndex - 1，
        // 其对应的后序数组左子树下标范围为 postStart, postStart + inorderPartitionIndex - inStart - 1
        root.left = buildTree(inStart, inorderPartitionIndex - 1, postStart, postStart + inorderPartitionIndex - inStart - 1);
        // 划分数组，中序数组的右子树下标范围为 inorderPartitionIndex + 1,inEnd，
        // 其对应的后序数组右子树下标范围为 postStart + inorderPartitionIndex - inStart, postEnd - 1
        root.right = buildTree(inorderPartitionIndex + 1, inEnd, postStart + inorderPartitionIndex - inStart, postEnd - 1);

        return root;

    }

}
