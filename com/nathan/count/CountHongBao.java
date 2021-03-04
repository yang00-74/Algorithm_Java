package com.nathan.count;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CountHongBao {
    public static void main(String[] args) {
        System.out.println(new CountHongBao().hongBao(10, 3));
    }

    public Map hongBao(int m, int n) {

        double sum = m;
        double[] a = new double[n];
        int index = 0;


        while (index < n - 1) {
            //BigDecimal deal with double type
            double number = (double) (Math.random() * m);
            BigDecimal bg = new BigDecimal(number);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            if (sum > f1 && f1 != 0) {
                a[index++] = f1;
                sum -= number;
            }
        }
        BigDecimal bg = new BigDecimal(sum);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        a[index] = f1;

        Map map = new HashMap();
        String b = "a";
        for (int j = 0; j < n; j++) {
            map.put(b + j, a[j]);
        }
        return map;

    }
}
