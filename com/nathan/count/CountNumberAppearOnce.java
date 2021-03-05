package com.nathan.count;

/**
 * 整数数组中只有一个/两个元素出现一次，其余都出现两次，找出它们来
 *
 * @author Administrator
 */
public class CountNumberAppearOnce {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 9, 4};
        int[] b1 = new int[1];
        int[] b2 = new int[1];
//		System.out.println(find1From2(a));
        System.out.println(find(a));
        findNumsAppearOnce(a, b1, b2);
        findOddNumber(10);
    }

    /**
     * 思路：使用异或运算符^，0与其他数字异或的结果是那个数字，相等的数字异或得 0
     *
     * */
    public static int find1From2(int[] a) {
        int len = a.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    public static void findOddNumber(int n) {
        for (int i = 1; i < n; i++) {
            if ((i & 1) != 0) {
                System.out.println("is a odd number:" + i);
            }
        }
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
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //两个出现一次，其余都出现两次的数组
        if (array == null || array.length <= 1) {
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum ^= array[i];
        }
        for (index = 0; index < 32; index++) {
            if ((sum & (1 << index)) != 0) break;
        }
        for (int i = 0; i < len; i++) {
            //筛选出一个出现一次的数，扔出去，剩下的数组异或即可找出另一个出现一次的数
            if ((array[i] & (1 << index)) != 0) {
                num2[0] ^= array[i];
            } else {
                num1[0] ^= array[i];
            }
        }
        System.out.println(num1[0] + " " + num2[0]);

    }

    public static int find(int[] a) {
        int len = a.length;
        boolean flag = true;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (a[i] == a[j] && i != j) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag == true) {
                return a[i];
            }
        }
        return 0;
    }
}
