package com.nathan.string;

public class RotateString796 {

    /**
     * 给定两个字符串, A 和 B。
     *
     * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True
     *
     *
     * 由于 A + A 包含了所有可以通过旋转操作从 A 得到的字符串，因此我们只需要判断 B 是否为 A + A 的子串即可
     * 链接：https://leetcode-cn.com/problems/rotate-string
     * */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        A = A + A;
        return A.contains(B);
    }
}
