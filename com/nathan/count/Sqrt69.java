package com.nathan.count;

import org.junit.Test;

import java.math.BigDecimal;

public class Sqrt69 {

    @Test
    public void test() {
        s = 5;
        System.out.println(BigDecimal.valueOf(sqrt(5)).setScale(5, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * 牛顿迭代
     * */
    public int mySqrt(int x) {
        s = x;
        if (0 == x) {
            return 0;
        }
        return (int) sqrt(x);
    }

    int s;

    public double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }

    /**
     * 一个找左边界的问题,我们需要找最小的n，n^2>=x
     */
    public int mySqrt2(int x) {
        long left = 0;
        long right = x / 2 + 1;
        long mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (mid * mid >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left * left == x ? left : left - 1);
    }
}
