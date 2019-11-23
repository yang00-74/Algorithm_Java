package DealWithString;

import java.util.Scanner;

public class StringUnzip {
    /**
     * �ж�һ���ַ����Ƿ���ѹ�����ģ�����ǣ������ѹ����ַ���
     * ���룺3klk4h(��ͬ�ַ���������3���������)
     * �����kkklkhhhh
     */
    public static String output;

    public static void main(String[] args) {

        StringUnzip un = new StringUnzip();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        un.unzip(input, output);
        System.out.println(output);

    }

    public void unzip(String input, String output) {
        if (input != null) {
            int len = input.length();
            char[] b = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            //��������鸳ֵ
            int[] count = new int[len];
            for (int j = 0; j < len; j++) {
                count[j] = 1;
            }

            //��������ʽ�Ƿ�Ϸ�
            for (int k = 1; k < len; k++) {
                if (b[k - 1] == b[k]) {
                    count[k] = count[k - 1] + count[k];
                }
                if (count[k] > 2) {
                    System.out.println("!error");
                    return;
                }
            }
            //��������ַ��Ƿ�Ϸ�
            for (int i = 0; i < len; i++) {
                if (b[i] > 'a' && b[i] < 'z') {
                    sb.append(b[i]);
                } else if (b[i] > '0' && b[i] < '9') {
                    int t = (int) (b[i] - 48);
                    for (int j = 0; j < t - 1; j++) {
                        sb.append(b[i + 1]);
                    }
                } else {
                    System.out.println("!error");
                    return;
                }

            }
            this.output = sb.toString().trim();

        }
    }

}