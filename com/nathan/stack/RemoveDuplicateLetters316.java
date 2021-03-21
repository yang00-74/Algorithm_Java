package com.nathan.stack;

import java.util.Stack;

public class RemoveDuplicateLetters316 {

    /**
     * 给定一个字符串 s ，请去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
     *
     * 思路：
     *  1. hash 表记录各个字符出现的次数，递增栈记录各个字符，boolean 数组记录栈中是否已经存在相应字符
     *  2. 根据 boolean 数据判断当前遍历的字符如果不在栈中
     *       a.此时判断其是否小于栈顶字符，再根据字符次数表判断栈顶字符是否还会出现，如果还会出现则将栈顶字符出栈，循环判断
     *       b.当前遍历字符入栈
     *  3. 更新字符次数表
     * */
    public String removeDuplicateLetters(String s) {
        // 记录字符串中各个字符出现的次数
        int[] counts = new int[26];
        for (Character c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }

        // 记录字符当前是否在栈中存在
        boolean[] existIn = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            // 栈中暂时不存在字符c 时做相关逻辑，存在则不处理
            if (!existIn[c - 'a']) {
                // 如果栈顶字符比字符c 大，并且栈顶字符后续还会出现，则将其出栈，更新字符存在数组
                while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 0) {
                    existIn[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                // 其他情况字符c 入栈，更新存在数组
                stack.push(c);
                existIn[c - 'a'] = true;
            }
            // 字符c 已经使用了一次，更新字符次数数组，减一
            counts[c - 'a'] -= 1;
        }
        StringBuilder res = new StringBuilder();
        for (char ch : stack) {
            res.append(ch);
        }
        return res.toString();
    }
}
