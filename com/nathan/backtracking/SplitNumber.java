package com.nathan.backtracking;


/**
 * 求一个数可分解为的所有加法式子
 * 例如： 4
 * 4
 * 3+1
 * 2+2
 * 2+1+1
 * 1+1+1+1
 * */
public class SplitNumber {

    public static void main(String[] args) {
//		new CountIntSplit().FindContinueSequence(10);
        new SplitNumber().backTracking(1,4);
    }

    int s[] = new int[100];//存储序列的数组
    int count = 0;//序列中数的存储个数
    int sum = 0;


    public void backTracking(int index, int n) {

        if (sum == n) {
            for (int i = 0; i <= count - 1; i++) {
                if (i == count - 1) {
                    System.out.println(s[i]);
                } else {
                    System.out.print(s[i] + "+");
                }
            }
            return;
        }
        if (sum > n) return;
        for (int i = index; i <= n; i++) {
            sum += i;
            s[count++] = i; // 解空间记录
            System.out.println("DFS: " + i + ", s[] index: " + count);
            backTracking(i,n);
            sum -= i;
            s[--count] = 0;//回退数组下标,返回上一层
        }
    }
}
