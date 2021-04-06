package com.nathan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens51 {
    /**
     *  N 皇后问题
     * */
    private List<List<String>> res = new ArrayList<>();
    private List<String> board = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if ( 0 == n) {
            return res;
        }
        backTracking(0, n);
        return res;
    }

    public void backTracking(int row, int n) {
        if (n == row) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPosValid(board, i, row, n)) {
                board.add(generateQueen(i, n));
                backTracking(row + 1, n);
                board.remove(board.size() - 1);
            }
        }
    }

    /**
     * @param board 已经填充了的棋盘
     * @param pos   皇后可能所在的列
     * @param row   皇后可能所在的行
     * @param n     皇后数量
     *
     * 皇后所在的位置与其他皇后间的关系
     * 1. 不能同行
     * 2. 不能同列
     * 3. 不能同斜线 （45度和135度角）
     */
    public boolean isPosValid(List<String> board, int pos, int row, int n) {

        // 纵向判断
        for (String s : board) {
            if ('Q' == s.charAt(pos)) {
                return false;
            }
        }

        // 判断 45 度 斜向有没有 Queen
        for (int i = row - 1, j = pos - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 判断 135 度 斜向有没有 Queen
        for (int i = row - 1, j = pos + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;

    }

    public String generateQueen(int pos, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            sb.append(".");
        }
        sb.append("Q");
        for (int i = pos + 1; i < n; i++) {
            sb.append(".");
        }
        return sb.toString();
    }

}
