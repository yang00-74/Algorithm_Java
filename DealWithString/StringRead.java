package DealWithString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringRead {
    public static void main(String[] args) throws NumberFormatException, IOException {

        FileReader One = new FileReader("src/eg.txt");
        BufferedReader Two = new BufferedReader(One);
        String s = null;

        int a[] = {18, 15, 7, 4, 9};

        while ((s = Two.readLine()) != null) {
            String[] str2 = s.split(" ");//读取字符串中数据
            int[] arr = new int[str2.length];//创建int数组
            int temp = 0;

            for (int j = 0; j < str2.length; j++) {
                arr[j] = Integer.parseInt(str2[j]);//字符串数组存储转化成int的数组
                temp = arr[j] + temp;
            }
            boolean flag = true;

            if (temp == 53) {
                for (int i = 0; i < arr.length; i++) {
                    if ((arr[i] - a[i]) > 1)
                        flag = false;
                }
                if (flag == true) {
                    System.out.println("correct");
                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("error");
            }
        }
        One.close();
        Two.close();
    }
}
