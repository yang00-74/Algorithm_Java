package com.nathan.count;

/**
 * Count the 1 appears in the given number
 *
 * @author Administrator
 */
public class HammingWeight191 {
    public static void main(String[] args) {
        System.out.println(numberOfOne(15));

    }

    /**
     * 返回给定数字二进制表达式中数字位为 '1' 的个数
     * 对于 n ，每次 n 和 n−1 做与运算，会把 n 的二进制表示中最低的一个 1 的位变成 0
     * 如 n = 15，二进制 ：1111
     *        n-1 二进制：1110
     *   n & (n-1) = 1110
     *
     * */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static int numberOfOne(int n) {
        int count = 0;
        char[] c = Integer.toBinaryString(n).toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 49) {
                count++;
            }
        }
        return count;
    }
}
