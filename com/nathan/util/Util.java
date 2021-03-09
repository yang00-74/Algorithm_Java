package com.nathan.util;

public class Util {

    public static void swap(int a[], int current, int target) {
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
}
