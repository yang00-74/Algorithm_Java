package com.nathan.leetcode.editor.cn;
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1753 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.nathan.tree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * 时间复杂度：O(N)，其中 N 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
 *
 * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。
 * 在平均情况下，二叉树的高度与节点个数为对数关系，即 O(log⁡N)。而在最坏情况下，树形成链状，空间复杂度为 O(N)
 *
 */
class Solution226 {

    public TreeNode invertTree2(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            TreeNode tmp = head.right;
            head.right = head.left;
            head.left = tmp;
            if (null != head.right) {
                stack.push(head.right);
            }
            if (null != head.left) {
                stack.push(head.left);
            }
        }
        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
