package DealWithString;

import java.util.Comparator;
import java.util.Arrays;

/**
 * �������е�Ԫ�����һ����С������
 *
 * @author Administrator
 */
public class StringSort {
    public static void main(String[] args) {
        int[] a = {45, 78, 1, 6};
        System.out.println(new StringSort().PrintMinNumber(a));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {//��д�������
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
//              return c2.compareTo(c1);//�Ӵ�С
            }
        });
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}