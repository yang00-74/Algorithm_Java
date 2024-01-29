package com.nathan.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 4287 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {

    /**
     * 括号必须成对存在才有效，则当字符串长度为奇数时，必然无效
     * 栈存储，将左半边入栈，遇到右半边时出栈，判断栈是否为空，或者栈顶元素是否成对
     */
    public boolean isValid(String s) {
        if (null == s || "".equals(s) || (s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (']' == c) {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else if (')' == c) {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if ('}' == c) {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (null == s || "".equals(s) || (s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
