package com.nathan.doublepointer;

public class MinWindow76 {
    /**
     * 一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     * <p>
     * 1. 用哈希表need记录字符串t中字母出现的次数；在后续操作中，如果出现某个字母的value为负数，则表示这个字母多余
     * 2. need_cnt用于记录当前剩余所需字母的数量，当所需字母数量为0时，说明当前滑动窗口包含了所需的所有字母，后续应当开始收紧窗口，去除多余字母；
     * 3. 滑动窗口的左右指针都从0开始，res用于记录符合要求的滑窗的左右指针
     * 4. right右移，遍历字符串s
     * 如果当前遍历到的字母（即right所指字母）在need中的value大于0，说明这是个需要的字母，need_cnt - 1
     * 无论当前字母是否是需要的字母，need相应的value都要 - 1，前面说过，如果出现某个字母的value为负数，则表示这个字母多余
     * 当need_cnt为0时，代表当前滑动窗口包含了所需的所有字符，后面开始收紧窗口，去除多于字符。
     * 进入while循环：当left所指的字符在need中value为0时，表示该字符不能再减少了，否则当前子字符串就不满足要求了，break；其他情况，表示left所指字符是多余的，left左移，去除该字符，相应need的value + 1（注意是先判断再右移的）
     * 当right - left < res[1] - res[0]时，当前字符串更小，更新res
     * right右移，更新滑动窗口，只有当滑动窗口又包含进新的所需字符时，left才会右移
     * 若res没有改变过，说明没有符合要求的子串，返回""；否则，返回 s[res[0]: res[1] + 1]
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        // 定义一个数字，用来记录字符串 t 中出现字符的频率，也就是窗口内需要匹配的字符和相应的频率
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int left = 0, right = 0;
        int match = 0;  // 匹配字符的个数
        int minLen = s.length() + 1;   // 最大的子串的长度
        // 子串的起始位置 子串结束的位置(如果不存在这样的子串的话，start，end 都是 0，s.substring 截取就是 “”
        int start = 0, end = 0;
        while (right < s.length()) {
            char charRight = s.charAt(right); // 右边界的那个字符
            map[charRight]--;   // 可以理解为需要匹配的字符 charRight 减少了一个
            // 如果字符 charRight 在 t 中存在，那么经过这一次操作，只要个数大于等于 0，说明匹配了一个
            // 若字符 charRight 不在 t 中，那么 map[charRight] < 0, 不进行任何操作
            if (map[charRight] >= 0) match++;
            right++;  // 右边界右移，这样下面就变成了 [)，方便计算窗口大小

            // 只要窗口内匹配的字符达到了要求，右边界固定，左边界收缩
            // 此时计数数组中的元素值为 0 的属于需匹配的目标字符，为负数的是多余的字符
            while (match == t.length()) {
                int size = right - left;
                if (size < minLen) {
                    minLen = size;
                    start = left;
                    end = right;
                }
                char charLeft = s.charAt(left);  // 左边的那个字符
                map[charLeft]++;  // 左边的字符要移出窗口
                // 不在 t 中出现的字符，移出窗口，最终能够达到的最大频次 map[charLeft] = 0
                // 如果恰好移出了需要匹配的一个字符，那么这里 map[charLeft] > 0, 也就是还要匹配字符 charLeft，此时 match--
                if (map[charLeft] > 0) match--;
                left++;  // 左边界收缩
            }
        }
        return s.substring(start, end);
    }
}
