package com.nathan.stack;

import java.util.Stack;

public class Trap42 {

    /**
     * 接雨水
     * <p>
     * 单调递减栈
     * 当后面的柱子高度比前面的低时，是无法接雨水的, 当找到一根比前面高的柱子，就可以计算接到的雨水,所以使用单调递减栈,对更低的柱子入栈
     * <p>
     * 更低的柱子后面如果能找到高柱子，就能接到雨水，所以入栈把它保存起来
     * 平地相当于高度 0 的柱子，没有什么影响
     * 当出现高于栈顶的柱子时
     * 1. 说明可以对前面的柱子结算了
     * 2. 计算已经到手的雨水，然后出栈前面更低的柱子
     * <p>
     * 计算雨水的时候需要注意的是
     * <p>
     * 雨水区域的右边 r 指的自然是当前索引 i
     * 底部是栈顶 st.top() ，因为遇到了更高的右边，所以它即将出栈，使用 cur 来记录它，并让它出栈
     * 左边 l 就是新的栈顶 st.top()
     * 雨水的区域全部确定了，水坑的高度就是左右两边更低的一边减去底部，宽度是在左右中间
     * 使用乘法即可计算面积
     */
    public long trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        for (int i = 0; i < height.length; i++) {
            // 水坑可能的右下标
            //单调栈模板，当遇到比栈中最低元素高的元素时，弹出栈里的元素开始计算盛水量
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                // 水坑底部下标
                int bottom = stack.pop();
                //无元素，取消操作
                if (stack.empty()) {
                    break;
                }
                // 水坑左边下标
                int left = stack.peek();
                long distance = i - left - 1;
                // 取最低点左右两边较低的墙壁的高度 减去底部高度获得 h
                int h = Math.min(height[i], height[left]) - height[bottom];
                if (h > 0) {
                    res += distance * h;
                }
            }
            stack.push(i);
        }
        return res;
    }

}
