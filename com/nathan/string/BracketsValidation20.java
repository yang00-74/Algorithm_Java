package com.nathan.string;

import java.util.Stack;

public class BracketsValidation20 {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     */
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if ('(' == c) {
                stack.push(')');
            } else if ('{' == c) {
                stack.push('}');
            } else if ('[' == c) {
                stack.push(']');
            } else {
                if (stack.empty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }


    public boolean isValid2(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        }

        return s.length() == 0;
    }
}
