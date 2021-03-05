package com.nathan.util;

public class Util {

    public static void swap(int a[], int current, int target) {
        int temp = a[current];
        a[current] = a[target];
        a[target] = temp;
    }
}
