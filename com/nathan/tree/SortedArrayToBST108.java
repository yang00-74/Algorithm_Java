package com.nathan.tree;

public class SortedArrayToBST108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。因此可以以升序序列中的任一个元素作为根节点，
     * 以该元素左边的升序序列构建左子树，以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树.
     * 又因为本题要求高度平衡，因此需要选择升序序列的中间元素作为根节点
     */
    public TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}
