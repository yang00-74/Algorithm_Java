package com.nathan.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

    @Test
    public void test() {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(a);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int height = matrix.length;
        int length = matrix[0].length;

        if (length == 0) {
            return res;
        }

        int top = 0;
        int right = length - 1;
        int bottom = height - 1;
        int left = 0;

        while (true) {

            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) break;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;

            // 从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;

            // 从下到上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }
}
