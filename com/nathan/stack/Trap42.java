package com.nathan.stack;

import java.util.Deque;
import java.util.LinkedList;
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
            int right = i;
            while (!stack.empty() && height[right] > height[stack.peek()]) {
                // 水坑底部下标
                int bottom = stack.pop();
                if (stack.empty()) {
                    break;
                }
                // 水坑左边下标
                int left = stack.peek();
                long distance = right - left - 1;
                int h = Math.min(height[right], height[left]) - height[bottom];
                if (h > 0) {
                    res += distance * h;
                }
            }
            stack.push(i);
        }
        return res;
    }

    public long maxWater(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        int left = 0, right = arr.length - 1;
        long sum = 0;
        // 找出左右边界的最小值作为水位高度
        int mark = Math.min(arr[left], arr[right]);
        while (left < right) {
            // 如果左边较低，则左边界向右遍历， 否则右边界向左移动
            if (arr[left] < arr[right]) {
                left++;
                // 如果当前标尺小于水位，则水量累加
                if (arr[left] < mark) {
                    sum += mark - arr[left];
                } else {
                    // 否则，将此标尺和右边边界高度进行比较，找出剩下数组中的新水位
                    mark = Math.min(arr[left], arr[right]);
                }
            } else {
                right--;
                // 同理，如果当前标尺小于水位，则水量累加
                if (arr[right] < mark) {
                    sum += mark - arr[right];
                } else {
                    // 否则，将此标尺和左边界的高度进行比较，找出剩余数组中的新水位
                    mark = Math.min(arr[right], arr[left]);
                }
            }
        }
        return sum;
    }

    public long maxWater2(int[] arr) {
        int len = arr.length;
        Deque<Integer> stack = new LinkedList<>();
        long result = 0;
        for (int i = 0; i < len; i++) {
            //单调栈模板，当遇到比栈中最低元素高的元素时，弹出栈里的元素并计算盛水量
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                //弹出栈顶元素坐标，也就是栈中最低元素的那个坐标
                int downInd = stack.pop();
                //无元素，取消操作
                if (stack.isEmpty())
                    break;
                //取最低点左右两边较低的墙壁的高度
                int minHeight = Math.min(arr[i], arr[stack.peek()]);
                //只有两边的元素高度都大于栈当前弹出的元素时，才表示能盛水
                //根据木桶原理，能盛多少水取决于边缘最低的那个元素
                if (minHeight > arr[downInd]) {
                    //minHeight-arr[downInd] 表示最低点与左右墙壁中较低元素的高度差(木桶原理)
                    //i是右边的墙壁的坐标，stack.peek()是左边墙壁的坐标
                    //i-stack.peek()-1 表示最低点 左右两边的墙壁之间的距离
                    //由于 高*宽=矩形面积 则结果加上该盛水量的大小
                    //上面的downInd是最低点元素的坐标，在循环最开始已经弹出栈了
                    result += (minHeight - arr[downInd]) * (long) (i - stack.peek() - 1);
                }

            }
            stack.push(i);
        }
        return result;
    }
}
