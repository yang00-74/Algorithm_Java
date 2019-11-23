
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringKuohao {
    public static void main(String[] args) {
        String str = null;
        int n = 0;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);

        n = scInt.nextInt();
        str = scStr.nextLine();

        countStr(str, n);
    }


    public static void countStr(String str, int n) {
        List list = new ArrayList();
        char c[] = str.toCharArray();
        int len = c.length;

        for (int i = 0; i < len; i++) {
            list.add(c[i]);
        }

        int count = 0;
        int flag = 0;
        int count0 = 1;

        while (flag < n) {
            for (int i = 0; i < list.size() - 1; i++) {
                if ((char) list.get(i) == '(' && (char) list.get(i + 1) == ')') {
                    list.remove(i);
                    list.remove(i);
                    count += 2;
                }
            }
            flag++;
        }
        System.out.println(count + " " + count0);

    }
}
