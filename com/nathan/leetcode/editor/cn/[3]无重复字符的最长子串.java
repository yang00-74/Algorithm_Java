package com.nathan.leetcode.editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 9811 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {

    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     *
     * 从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
     *
     *
     * 哈希表 dic统计： 指针 j 遍历字符 s ，哈希表统计字符 s[j] 最后一次出现的索引 。
     * 更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]]，每轮更新左边界 i ，保证区间 [i + 1, j] 内无重复字符且最大。
     * i=max(dic[s[j]],i)
     *
     * 更新结果 res ： 取上轮 res 和本轮双指针区间 [i + 1,j] 的宽度（即 j - i）中的最大值。
     * res=max(res,j−i)
     * */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        Map<Character, Integer> indexMap = new HashMap<>(s.length());
        int res = 0;
        int leftIndex = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (indexMap.containsKey(chars[i])) {
                // max 防止左指针回退
                leftIndex = Math.max(leftIndex, indexMap.get(chars[i]));
            }
            indexMap.put(chars[i], i);
            res = Math.max(res, i - leftIndex);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
