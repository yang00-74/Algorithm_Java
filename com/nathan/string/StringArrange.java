package com.nathan.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @input String
 * @output 输出该字符串所有单个字符重新排列的不重复的字符串
 */
public class StringArrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ArrayList<String> list = new StringArrange().Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ",");
            }
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return result;
        }
        HashSet<String> set = new HashSet<String>();

        fun(set, str.toCharArray(), 0);

        result.addAll(set);
        Collections.sort(result);//工具类排序
        return result;
    }

    void fun(HashSet<String> set, char[] str, int k) {
        if (k == str.length) {
            set.add(new String(str));
            System.out.println(new String(str));
            return;
        }
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);

            fun(set, str, k + 1);

            swap(str, i, k);
        }
    }

    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
