package com.nathan.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
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
        Map<Character, Integer> dic = new HashMap<>();
        int startIndex = -1;
        char[] chars = s.toCharArray();
        int res = 0;
        for (int j = 0; j < chars.length; j++) {
            if (dic.containsKey(chars[j])) {
                startIndex = Math.max(startIndex, dic.get(chars[j]));
            }
            dic.put(chars[j], j);
            res = Math.max(res, j - startIndex);
        }
        return res;
    }
}
