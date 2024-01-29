package com.nathan.leetcode.editor.cn;
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 2123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.nathan.tree.TreeNode;

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
 * 首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，
 * 就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
 * 该函数的计算如下：
 *
 * 1.空节点的最大贡献值等于 0
 *
 * 2.非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
 *
 * 例如，考虑如下二叉树。
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 叶节点 9、15、7 的最大贡献值分别为 9、15、7。
 *
 * 得到叶节点的最大贡献值之后，再计算非叶节点的最大贡献值。节点 2020 的最大贡献值等于 20+max(15,7)=35，
 * 节点 −10 的最大贡献值等于 −10+max(9,35)=25。
 *
 * 上述计算过程是递归的过程，因此，对根节点调用函数 maxGain，即可得到每个节点的最大贡献值。
 *
 * 根据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？
 * 对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，
 * 如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和。
 * 维护一个全局变量 maxSum 存储最大路径和，在递归过程中更新 maxSum 的值，最后得到的 maxSum 的值即为二叉树中的最大路径和。
 *
 * 时间复杂度：O(N)，对每个节点访问不超过 2 次
 *
 * 空间复杂度：O(N)，空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，最坏情况下，二叉树的高度等于二叉树中的节点个数。
 *
 */
class Solution124 {

    int maxRes = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxRes;
    }

    public int dfs(TreeNode root) {
        // 2.遍历的终止条件
        if (null == root) {
            return 0;
        }
        // 1.往下遍历左右子节点，计算最大贡献值，只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        // 3.当前节点形成的最大路径和为该节点的值与左右子节点的最大贡献值叠加
        int maxVal = root.val + leftMax + rightMax;
        maxRes = Math.max(maxVal, maxRes);
        // 4.当前节点不是路径的根节点时，只能返回单边路径的最大贡献值给上一层
        return root.val + Math.max(leftMax, rightMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
