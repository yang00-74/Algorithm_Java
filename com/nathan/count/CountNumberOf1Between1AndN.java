package com.nathan.count;

public class CountNumberOf1Between1AndN {
    /**
     * 统计一定范围内全部整数中数字1出现的次数
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = NumberOf1Between1AndN_Solution(13);
        System.out.println(n);

    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int m = i;
            while (m > 0) {
                if (m % 10 == 1) count++;
                m = m / 10;
            }
        }
        return count;
    }
}
