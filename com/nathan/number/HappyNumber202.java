package com.nathan.number;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {

    /**
     * leet code 202
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * <p>
     * 「快乐数」定义为：
     * <p>
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果 可以变为  1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 true ；不是，则返回 false
     */

    // 无限循环则存在环，可以使用快慢指针判断
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    // 无限循环也就是说求和的过程中 sum 会反复出现
    public boolean isHappy2(int n) {
        if (1 == n) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        int sum = n;
        while (true) {
            sum = squareSum(sum);
            if (1 == sum) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }

    }

    public int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }


}
