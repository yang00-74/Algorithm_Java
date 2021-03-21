package com.nathan.number;

/**
 * 判断一个数是否是回文数，例如 1221 是回文数，12 不是
 */
public class PalindromeNumber9 {

    /**
     * 思路：将数字低位数上的数反转
     *
     * 对于数字 1221，如果执行 1221 % 10，将得到最后一位数字 1，要得到倒数第二位数字，
     * 可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，
     * 就可以得到倒数第二位数字。如果把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了反转后的数字。
     * 如果继续这个过程，我们将得到更多位数的反转数字。
     *
     * 如何知道反转数字的位数已经达到原始数字位数的一半？
     *
     * 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，
     * 就意味着已经处理了一半位数的数字了
     *
     */
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || x % 10 == 0 && 0 != x) {
            return false;
        }
        int reverseNum = 0;
        while (reverseNum < x) {
            int lastOne = x % 10;
            reverseNum = reverseNum * 10 + lastOne;
            x = x / 10;
        }
        return reverseNum == x || reverseNum / 10 == x;
    }

    public boolean isPalindrome2(int n) {
        int m = n;
        String s = String.valueOf(m);
        char[] ch = s.toCharArray();
        int len = ch.length;
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
    }

}
