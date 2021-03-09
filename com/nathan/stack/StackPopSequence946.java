package com.nathan.stack;

import java.util.Stack;
/**
 * 给出元素进栈顺序，判断出栈序列是否合法，
 * 【思路】借用一个辅助的栈，遍历压栈顺序，先将第一个放入栈中，这里是1，
 * 然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，
 * 所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈数组下标向后移动一位，
 * 直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，
 * 说明弹出序列不是该栈的弹出顺序。
举例：
入栈1,2,3,4,5
出栈4,5,3,2,1
首先1入辅助栈，此时栈顶1≠4，继续入栈2
此时栈顶2≠4，继续入栈3
此时栈顶3≠4，继续入栈4
此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
 *
 */

public class StackPopSequence946 {


    public boolean isPopOrder(int[] pushed, int[] popped) {
        if (pushed.length == 0) return popped.length == 0;
        Stack<Integer> s = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            s.push(pushed[i]);//入栈操作
            while (!s.empty() && s.peek() == popped[popIndex]) {
                //如果栈不为空，且栈顶元素等于弹出序列
                s.pop();//出栈
                popIndex++; //弹出序列向后一位
            }
        }
        return s.empty();
    }
}