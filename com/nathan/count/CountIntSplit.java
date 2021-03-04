package com.nathan.count;

public class CountIntSplit {

    public static void main(String[] args) {
//		new CountIntSplit().FindContinueSequence(10);
        new CountIntSplit().dfs(1,4);
    }

    int s[] = new int[100];//存储序列的数组
    int count = 0;//序列中数的存储个数
    int sum = 0;


    public void dfs(int index, int n) {

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
            dfs(i,n);
            sum -= i;
            s[--count] = 0;//回退数组下标,返回上一层
        }

    }

    //输出所有连续相加等于n的序列
    public void FindContinueSequence(int n) {

        for (int i = 1; i <= n / 2; i++) {
            int sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;
                if (sum > n) {
                    break;
                } else if (sum == n) {
                    for (int k = i; k <= j; k++) {//连续整数，故可遍历
                        if (k == j) {
                            System.out.println(k);
                        } else {
                            System.out.print(k + ",");
                        }
                    }
                }
            }
        }

    }
}
