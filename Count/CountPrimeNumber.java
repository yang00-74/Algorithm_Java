package Count;

import java.util.ArrayList;
import java.util.List;

/**
 * ͳ��һ�������ڵ�3������֮�͵��ڸ��������
 *
 * @author Administrator
 */
public class CountPrimeNumber {
    public static void main(String[] args) {
        CountPrimeNumber c = new CountPrimeNumber();
        c.count(15);
    }

    private void count(int number) {
        if (number == 1 || number == 2) {
            return;
        }
        int count = 0;

        List list = new ArrayList();
        list.add(0, 2);
        int index = 1;
        boolean flag = false;

        for (int i = 3; i < number; i++) {

            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    //һ����鵽iΪ��������flag��Ϊfalse��������ѭ��
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag == true) {
                list.add(index, i);
                index++;
            }
        }

        int len = list.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (list.get(i) != list.get(j) && list.get(i) != list.get(k) && list.get(k) != list.get(j)
                            && (int) list.get(i) + (int) list.get(j) + (int) list.get(k) == number) {

                        System.out.println(list.get(i) + " " + list.get(j) + " " + list.get(k));
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
