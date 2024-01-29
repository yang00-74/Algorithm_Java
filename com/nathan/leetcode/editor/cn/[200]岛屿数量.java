package com.nathan.leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 2376 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {

    /**
     * 时间复杂度：O(MN)，其中 M 和 N 分别为行数和列数。
     *
     * 空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 MN
     * */
    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ('1' == grid[i][j]) {
                    // 遍历所有的陆地，抵达边界 return
                    dfs(grid, i, j);
                    // 当 dfs 退出时，必然已经遍历出了一块岛屿
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return;
        }
        // 遍历到非未遍历的陆地格即返回
        if ('1' != grid[i][j]) {
            return;
        }
        // 标记已经遍历的陆地格
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private boolean inArea(char[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[i].length;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
