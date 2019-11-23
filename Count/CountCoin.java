
import java.util.Scanner;

public class CountCoin {

    public static void main(String[] args) {

//		System.out.println("输入硬币数量数组（空格分隔）：");
        Scanner sc0 = new Scanner(System.in);
        String s = sc0.nextLine();


        String str[] = s.split(" ");
        if (str.length != 7) {
            System.out.println("输入不合法，请以空格分隔");
            return;
        }

        int a[] = new int[6];
        for (int i = 0; i < 6; i++) {
            a[i] = Integer.valueOf(str[i]);
        }
        int n = Integer.valueOf(str[6]);

        System.out.println(new CountCoin().countCoin(a, n));
    }

    public String countCoin(int a[], int n) {
        int[] b = {1, 5, 10, 50, 100, 500};
        if (a == null || b.length != a.length || n <= 0) return "NOWAY";
        int count = 0;

        int len = b.length;

        boolean flag = true;
        while (n > 0 && flag == true) {

            for (int i = len - 1; i >= 0; i--) {
                flag = false;
                if (n >= b[i] && a[i] > 0) {
                    n = n - b[i];
                    a[i] = a[i] - 1;
                    count++;
                    i++;
                    flag = true;
                }
            }


        }
        if (n < 0 || n > 0) return "NOWAY";
        else if (n == 0) return String.valueOf(count);

        return null;
    }
}
