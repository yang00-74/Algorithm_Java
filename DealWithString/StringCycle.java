package DealWithString;

/**
 * �жϻ����ִ�
 * ��һ��˼·��ʹ��ջ���ַ����ָ�Ϊ char ��ջ,���γ�ջ��ԭ�ַ����Ƚϼ���
 */

public class StringCycle {
    public static void main(String[] args) {
        String s = "lkjljkl";
        char[] c = s.toCharArray();
        int len = c.length - 1;


        for (int start = 0, end1 = len; start <= len && end1 >= 0; start++, end1--) {
            if (c[start] != c[end1]) {
                System.out.println("���ǻ���");
                return;
            }
        }
        System.out.println("�ǻ���");
    }
}
