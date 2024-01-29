package com.nathan.leetcode.editor.cn;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 1371 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {

    private List<String> res = new ArrayList<>();
    private Deque<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(null == s || "".equals(s)) {
            return res;
        }
        backTracking(s, 0);
        return res;
    }

    /**
     * 时间复杂度：O(3^SEG_COUNT×∣s∣)
     * 由于 IP 地址的每一段的位数不会超过 3，因此在递归的每一层，我们最多只会深入到下一层的 3 种情况。
     * 由于 SEG_COUNT=4 对应着递归的最大层数，所以递归本身的时间复杂度为 O(3^SEG_COUNT)
     * 如果我们复原出了一种满足题目要求的 IP 地址，那么需要 O(∣s∣)的时间将其加入答案数组中，
     * 因此总时间复杂度为 O(3^SEG_COUNT×∣s∣)
     * <p>
     * 空间复杂度：O(SEG_COUNT)，这里只计入除了用来存储答案数组以外的额外空间复杂度。
     * 递归使用的空间与递归的最大深度 SEG_COUNT 成正比
     */
    private void backTracking(String s, int startIndex) {
        if (path.size() == 4) {
            // 4.ip 为 4 段，且将字符全部使用，找到一个解
            if (startIndex == s.length()) res.add(String.join(".", path));
            return;
        }

        // 1.递归主体
        for (int i = startIndex; i < s.length(); i++) {
            // 2. 单层判断
            if (!isIpSegment(s, startIndex, i)) {
                // 不合法，直接结束本层
                break;
            }
            // 3.解空间记录
            path.addLast(s.substring(startIndex, i + 1));
            // 上一层的尾部位置为下一层的起始
            backTracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isIpSegment(String s, int start, int end) {
        // 首字符为 0，且片段长度不为 1，必然不是合法 ip 片段
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + s.charAt(i) - '0';
        }
        return 0 <= num && num <= 255;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
