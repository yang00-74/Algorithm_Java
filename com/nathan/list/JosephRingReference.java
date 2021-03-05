package com.nathan.list;

/**
 * 约瑟夫环升级问题，所有人生命为1，某人被点中，生命-1，为零出局
 * 若某人邻座都淘汰了，生命加1，只加一次，
 * 判断最后剩下的是谁
 *
 * @author Administrator
 */
public class JosephRingReference {
    public static void main(String[] args) {
        new JosephRingReference().count(9, 3);
    }

    public void count(int N, int M) {

        int rs[] = new int[N];
        boolean flag[] = new boolean[N];

        for (int i = 0; i < N; i++) { //初始化标记数组，每个人生命为1
            rs[i] = 1;
            flag[i] = true;
        }

        int n = N;//剩余的人数，报出M的人出局
        int m = 0;//报数的编号,初始为0,

        while (n > 1) {
            for (int j = 0; j < N; j++) {
                if (rs[j] != 0) {//遍历判断某人是否出局，出局则跳过报数
                    m++;
                    if (m == M) {
                        m = 0;
                        if (n > 1) {//判断避免M=1时一次循环就把全部人淘汰
                            rs[j] = rs[j] - 1;//点到的人生命值-1
                            if (rs[j] == 0) {
                                n--;
                            }
                        }
                    }
                }
            }
            //当某人两边近邻都出局，其生命+1,加一次后flag置为false
            //数组尾部位置的判断
            if (rs[0] == 0 && rs[N - 1] != 0 && rs[N - 2] == 0) {
                if (flag[N - 1] == true) {
                    rs[N - 1] += 1;
                    flag[N - 1] = false;
                }
            }
            //数组头部位置的判断
            if (rs[0] != 0 && rs[N - 1] == 0 && rs[1] == 0) {
                if (flag[0] == true) {
                    rs[0] += 1;
                    flag[0] = false;
                }
            }
            for (int i = 1; i < N - 1; i++) {
                if (rs[i - 1] == 0 && rs[i + 1] == 0 && rs[i] != 0) {
                    if (flag[i] == true) {
                        rs[i] += 1;
                        flag[i] = false;
                    }
                }
            }

        }
        //输出留下的人
        for (int k = 0; k < N; k++) {
            if (rs[k] >= 1) {
                System.out.println("最后留下的是第" + (k + 1) + "号。");
                break;

            }
        }
    }
}
