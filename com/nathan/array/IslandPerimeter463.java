package com.nathan.array;

import org.junit.Test;

public class IslandPerimeter463 {

    @Test
    public void main() {
        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (1 == grid[i][j]) {
                    // 只有一个岛屿，从第一个陆地方格进入即可
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 边缘越界，周长加1
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        // 每当在 DFS 遍历中，从一个陆地方格走向一个非陆地方格，就将周长加 1
        if (grid[r][c] == 0) {
            return 1;
        }
        // 已经遍历过的陆地方格，相邻，不能计入周长
        if (grid[r][c] == 2) {
            return 0;
        }
        // 标记已经遍历过的陆地方格
        grid[r][c] = 2;
        // 上下左右四个方向遍历
        return dfs(grid, r + 1, c) + dfs(grid, r - 1, c)
                + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }

}
