package com.nathan.util;

public class Util {

    public static void swap(int a[], int current, int target) {
        if (current == target) return;
        int temp = a[current];
        a[current] = a[target];
        a[target] = temp;
    }

    public static int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void reverseCharArray(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static <V> void printArray(V[] array) {
        if (0 == array.length) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
