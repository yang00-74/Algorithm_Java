package com.nathan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射与电话按键相同
     * */
    private String[] phoneMap = new String[]{
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        backTracking(digits, 0);
        return res;
    }

    public void backTracking(String digits, int digitIndex) {
        if (digitIndex == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char number = digits.charAt(digitIndex);

        String letters = phoneMap[number - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backTracking(digits, digitIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
