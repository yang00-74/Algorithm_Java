package Count;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 找中位数和出现次数超过数组长度一半的数
 *
 * @author Administrator
 */
public class FindMiddleNumber {

    public static void main(String[] args) {
        double[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        //System.out.println(new dfd().MoreThanHalfNum_Solution(a));
        System.out.println(new FindMiddleNumber().MiddleNumber(a));
    }

    //找中位数
    public Double MiddleNumber(double a[]) {
        ArrayList<Double> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        Collections.sort(list);
        int len = list.size();
        if (len % 2 == 0) {
            return (list.get(len / 2) + list.get(len / 2 - 1)) / 2;
        } else {
            return list.get(len / 2);
        }

    }

    public int MoreThanHalfNum_Solution(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) count++;
            }

            if (count > array.length / 2) return array[i];

        }
        return 0;
    }
}
