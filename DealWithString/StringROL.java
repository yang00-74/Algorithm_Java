package DealWithString;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定字符串,从该字符串的数组下标 n-1 开始,将该下标之后的字符移动到字符开头
 */
public class StringROL {

    public static void main(String[] args) {
        String str = "abcdef";
        // 队列变化：fedcba-> cbafed-> defabc
        System.out.println(new StringROL().LeftRotateString(str, 3));
    }

    public String LeftRotateString(String str, int n) {
        if (str.length() == 0 || n == 0) return str;

        Queue q = new ArrayBlockingQueue(str.length());

        char[] a = str.toCharArray();
        int len = a.length;
        for (int i = 0; i < len; i++) {
            q.add(a[i]);
        }

        for (int j = 0; j < n; j++) {
            q.add(q.poll());
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++) {
            sb.append((char) q.poll());
        }
        return sb.toString();
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        A = A + A;
        return A.contains(B);
    }
}
