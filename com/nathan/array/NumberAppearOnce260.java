package com.nathan.array;

/**
 * 整数数组中只有一个/两个元素出现一次，其余都出现两次，找出它们来
 *
 * @author Administrator
 */
public class NumberAppearOnce260 {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 9, 4};
        findNumsAppearOnce(a);
    }

    /**
     *
     * 首先可知当只有一个数出现一次时，把数组中所有的数依次异或运算，最后剩下的就是落单的数，因为成对出现的都抵消了。
     *
     * 按照这个思路，首先还是先异或，最后剩下的数字肯定是A、B异或的结果 C，
     * 以数组 [1,2,2,1,3,5]为例， 则 A=3（0011）,B=5（0101），结果C=6（0110）。
     * C 的二进制表示中 1 所在的位，其实就是A 和 B 的二进制表示中数值不同的位。
     * 我们取第一个1 所在的位数 index，可知是（0010 = 1<<index）即 index=1，据此把原数组分成两组，
     * 分组标准是数字二进制表示的第2位是否为1。这样成对的数字肯定在一个组中，因为相同数字所有位的数值都相同，
     * 而不同的数肯定不在同一组。之后把这两个组按照最开始的思路，依次异或，剩下的两个结果就是这两个只出现一次的数字
     */
    public static int[] findNumsAppearOnce(int[] nums) {
        //两个出现一次，其余都出现两次的数组
        int num1 = 0, num2 = 0;
        if (nums == null || nums.length <= 1) {
            return new int[]{num1, num2};
        }
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++) {
            sum ^= nums[i];
        }
        int div = 1;
        while ((div & sum) == 0) {
            div <<= 1;
        }
        for (int i = 0; i < len; i++) {
            //按照分割数 div 将数组分成两部分，即可找出两个出现一次的数
            if ((nums[i] & div) != 0) {
                num2 ^= nums[i];
            } else {
                num1 ^= nums[i];
            }
        }
        System.out.println(num1 + " " + num2);
        return new int[]{num1, num2};
    }
}
