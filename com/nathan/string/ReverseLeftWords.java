package com.nathan.string;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定字符串,从该字符串的数组下标 n-1 开始,将该下标之后的字符移动到字符开头
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(new ReverseLeftWords().leftRotateString(str, 3));
    }

    /**
     * 使用队列作为辅助结构，利用队列先进先出的特性完成字符串左移
     */
    public String leftRotateString(String str, int n) {
        if (str.length() == 0 || n == 0 || str.length() < n) {
            return str;
        }
        Queue q = new ArrayBlockingQueue(str.length());

        char[] a = str.toCharArray();
        int len = a.length;
        // 首先全部入队
        for (int i = 0; i < len; i++) {
            q.add(a[i]);
        }
        // 其次把头部 n 个字符出队再入队
        for (int j = 0; j < n; j++) {
            q.add(q.poll());
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++) {
            sb.append((char) q.poll());
        }
        return sb.toString();
    }


    /**
     * 字符串 S 为 abcdef，n=3，设X=abc，Y=def，原字符串可以表示成XY
     * 此时用 T表示翻转， X 的翻转为XT，即XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果
     */
    public String leftRotateString2(String str, int n) {
        if (null == str || str.length() == 0 || n == 0 || str.length() < n) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverseCharArray(chars, 0, n - 1);
        reverseCharArray(chars, n, chars.length - 1);
        reverseCharArray(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    public void reverseCharArray(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
