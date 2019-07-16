package Others;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
 * 从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，
 * 数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
 */
public class JosephRing {

    public static void main(String[] args) {
        //50个人，从第一个人开始数，数到3的人出列
        countThree(9, 0, 3);
    }

    /**
     * @param n     人的总数
     * @param start 开始报数的序号，start < n
     * @param m     出列的标记(可以大于n)
     */
    private static void countThree(int n, int start, int m) {

        List<Integer> list = new ArrayList<Integer>();

        //初始化列表
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            //将前面不被淘汰的移入列表尾端
            for (int j = 0; j < m - 1; j++) {
                list.add(list.remove(start));
            }
            //打印出列序号
            //System.out.println(list.remove(start));
            list.remove(start);//淘汰的直接移除
        }
        //打印最后留下的序号
        System.out.println(list.get(0));
    }
}
