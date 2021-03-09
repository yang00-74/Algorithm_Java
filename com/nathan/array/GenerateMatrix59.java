package com.nathan.array;

public class GenerateMatrix59 {

    /**
     * 给定一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     * <p>
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     */
    public int[][] generateMatrix(int n) {
        int leftIndex = 0;
        int topIndex = 0;
        int rightIndex = n - 1;
        int bottomIndex = n - 1;
        int count = 1;
        int[][] matrix = new int[n][n];
        int max = n * n;
        while (count <= max) {
            // 从左往右填写矩阵, 行不变，列变
            for (int i = leftIndex; i <= rightIndex; i++) {
                matrix[topIndex][i] = count++;
            }
            // 填写完上边一行，行号 +1
            topIndex++;

            // 从上到下填写矩阵，列不变，行变
            for (int i = topIndex; i <= bottomIndex; i++) {
                matrix[i][rightIndex] = count++;
            }
            // 填写完右边一列，列号 -1
            rightIndex--;

            // 从右往左填写矩阵, 行不变，列变
            for (int i = rightIndex; i >= leftIndex; i--) {
                matrix[bottomIndex][i] = count++;
            }
            // 填写完下边一行，行号 -1
            bottomIndex--;

            // 从下到上填写矩阵，列不变，行变
            for (int i = bottomIndex; i >= topIndex; i--) {
                matrix[i][leftIndex] = count++;
            }
            // 填写完左边一列，列号 +1
            leftIndex++;
        }

        return matrix;
    }
}
