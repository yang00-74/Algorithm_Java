package DealWithString;

import java.util.Scanner;

public class StringFindMaxMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�������֣�������Ҫ��ͬ,ֻҪ��Ƚ���ͬ�±�Ԫ�أ���");
        String s2 = sc.nextLine();
        String s1 = sc.nextLine();
        int n = findMatch0(s1, s2);
        System.out.println(n);

    }

    public static int findMatch0(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        if (len1 != len2) {
            return -1;
        }
        int count[] = new int[len1];
        for (int j = 0; j < len1; j++) {
            count[j] = 0;
        }
        for (int i = 0; i < len1; i++) {
            if (c1[i] < '0' || c1[i] > '9' || c2[i] < '0' || c2[i] > '9') {
                return -1;
            }
            if (c1[i] == c2[i]) {
                count[i] = 1;
            }
        }
        for (int k = 1; k < len1; k++) {
            if (count[k] > 0) {
                count[k] = count[k] + count[k - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < len1; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        if (max > 1) {
            return max;
        }
        return 0;
    }
}


