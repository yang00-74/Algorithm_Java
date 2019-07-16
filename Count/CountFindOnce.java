package Count;

/**
 * 整数数组中只有一个/两个元素出现一次，其余都出现两次，找出它们来
 *
 * @author Administrator
 */
public class CountFindOnce {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 9, 4};
        int[] b1 = new int[1];
        int[] b2 = new int[1];
//		System.out.println(find1From2(a));
        System.out.println(find(a));
        findNumsAppearOnce(a, b1, b2);
        findOddNumer(10);
    }

    public static int find1From2(int[] a) {
        int len = a.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    public static void findOddNumer(int n) {
        for (int i = 1; i < n; i++) {
            if ((i & 1) != 0) {
                System.out.println("is a odd number:" + i);
            }
        }
    }

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
