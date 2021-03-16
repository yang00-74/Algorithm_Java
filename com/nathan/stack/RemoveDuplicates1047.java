package com.nathan.stack;

import java.util.Stack;

public class RemoveDuplicates1047 {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除
     * */
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character character: chars) {
            if (stack.isEmpty() || stack.peek() != character) {
                stack.push(character);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
