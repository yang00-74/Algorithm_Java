package Others;

import java.util.ArrayList;
import java.util.List;

/**
 * Լɪ�򻷣���֪n����(�Ա��1��2��3...n�ֱ��ʾ)Χ����һ��Բ����Χ��
 * �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;������һ�����ִ�1��ʼ������
 * ����m���Ǹ����ֳ���;���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
 */
public class JosephRing {

    public static void main(String[] args) {
        //50���ˣ��ӵ�һ���˿�ʼ��������3���˳���
        countThree(5, 4, 3);
    }

    /**
     * @param n     �˵�����
     * @param start ��ʼ��������ţ�start < n
     * @param m     ���еı��(���Դ���n)
     */
    private static void countThree(int n, int start, int m) {

        List<Integer> list = new ArrayList<Integer>();

        //��ʼ���б�
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int j = 0; j < start-1; j++) {
            // ����list��ʹ��һ���������� k λ���б�ͷ�������� k ֮ǰ���˲�����뻷�н���ѭ��
            list.add(list.remove(0));
        }

        while (list.size() > 1) {
            //��ǰ�治����̭�������б�β��
            for (int j = 0; j < m - 1; j++) {
                list.add(list.remove(0));
            }
            //��ӡ�������
            //System.out.println(list.remove(start));
            list.remove(0);//��̭��ֱ���Ƴ�
        }
        //��ӡ������µ����
        System.out.println(list.get(0));
    }
}
