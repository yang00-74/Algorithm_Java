package com.nathan.backtracking;

import java.util.*;

/**
 * @input String
 * @output 输出该字符串所有单个字符重新排列的不重复的字符串
 */
public class StringArrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ArrayList<String> list = new StringArrange().permutation(str);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ",");
            }
        }
    }

    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        TreeSet<String> set = new TreeSet<>();
        range(str.toCharArray(), 0, set);

        result.addAll(set);
        Collections.sort(result);//工具类排序
        return result;
    }

    public void range(char[] chars, int pos, Set<String> set) {
        if (pos == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        for (int i = pos; i < chars.length; i++) {
            swap(chars, i, pos);
            range(chars, pos + 1, set);
            swap(chars, i, pos);
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
