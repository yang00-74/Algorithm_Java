package Count;

import java.util.Scanner;

/**
 * 求数字 N 以内的一对数字 (i,j),(i%j)>= K.
 *
 * @input N, K.
 * @out 输出数对的数量
 */

public class CountShuDui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();

        System.out.println(new CountShuDui().findShuDui(n, k));
    }

    public int findShuDui(long n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j >= k) {
                    count++;
                    System.out.println("i:" + i + " j:" + j);
                }
            }
        }
        return count;
    }

}
