package com.nathan.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddresses93 {
    /**
     * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     *
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址
     *
     * */
    private List<String> res = new ArrayList<>();
    private Deque<String> sb = new ArrayDeque<>();
    public List<String> restoreIpAddresses(String s) {
        if (null == s || "".equals(s)) {
            return res;
        }
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int startIndex) {
        // 存储了 4 个段需要 return
        if (sb.size() == 4) {
            // 如果遍历的字符达到字符串末尾，可以认为找到了一个 ip
            if (startIndex == s.length()) {
                res.add(String.join(".", sb));
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                sb.addLast(s.substring(startIndex, i + 1));
                backTracking(s, i + 1);
                sb.removeLast();
            } else {
                // 不合法的话直接结束本层循环
                break;
            }
        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if ('0' == s.charAt(start) && start != end) {
            return false;
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c > '9' || c < '0') {
                return false;
            }
            count = count * 10 + (c - '0');
            if (count > 255) {
                return false;
            }
        }
        return true;
    }
}
