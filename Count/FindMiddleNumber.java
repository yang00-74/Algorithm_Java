package Count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ����λ���ͳ��ִ����������鳤��һ�����
 *
 * @author Administrator
 */
public class FindMiddleNumber {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new FindMiddleNumber().MoreThanHalfNum_Solution(a));
       // System.out.println(new FindMiddleNumber().MiddleNumber(a));
    }

    //����λ��
    public Double MiddleNumber(double a[]) {
        ArrayList<Double> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        Collections.sort(list);
        int len = list.size();
        if (len % 2 == 0) {
            return (list.get(len / 2) + list.get(len / 2 - 1)) / 2;
        } else {
            return list.get(len / 2);
        }

    }

    /**
     * ���⣺�ҳ������г��ִ����������鳤��һ���Ԫ�ء�
     *
     * �ⷨ��
     *  ����һ���Ƚ������е�Ԫ����������Ŀ��Ԫ�ص������������鳤�ȵ�һ�룬�������������м�Ԫ��(���������λ��)����Ŀ��Ԫ�ء�
     *  ʱ�临�Ӷ�O(nlogn)
     *
     *  ������������һ��hashmap��keyΪԪ�ص�ֵ��valueΪԪ�س��ֵĴ�����Ȼ�����hashmap�Ϳ����ҵ�Ŀ��Ԫ���ˡ�
     *  ʱ�临�Ӷ�O(n)���ռ临�Ӷ�ΪO(n)
     *
     *  ��������
     *  ˼�룺��һ��Ŀ��Ԫ�غ�һ������Ԫ�ؽ��е���������Ŀ��Ԫ�ص�������������Ԫ�ص��������ʾ�����ε�����ʣ�µ�Ԫ�ؼ�Ŀ��Ԫ�ء�
     *      *
     *      * ���裺
     *      *  1)�ڱ��������ʱ�򱣴�����ֵ�������е�һ��Ԫ��(target) �� ��Ԫ�س��ֵĴ���(times)��
     *      *  2)�����Ǳ�������һ��Ԫ�ص�ʱ�������һ��Ԫ�غ�����֮ǰ�����Ԫ����ȣ��������1��
     *      *  3)�����һ��Ԫ�غ�����֮ǰ�����Ԫ�ز���ȣ��������1��
     *      *  4)�������Ϊ�㣬������Ҫ������һ��Ԫ�أ����ҰѴ�������Ϊ1��
     *      *  5)����Ŀ��Ԫ�س��ֵĴ�������������Ԫ�س��ֵĴ���֮�ͻ�Ҫ�࣬����Ŀ��Ԫ�ؿ϶������һ�ΰѴ�����Ϊ1ʱ��Ӧ��Ԫ�ء�
     *
     *  ʱ�临�Ӷ�O(n)
     *
     * @param array ��������, ��֪����ĳ�������ִ��� > ���鳤��һ��.
     * @return ���ظ���
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int result = array[0]; // ��¼��ѡֵ
        int count = 1; // ��¼��ѡֵ���ִ���,Ϊ 0 ����º�ѡֵ

        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count++;
            } else if (result == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
