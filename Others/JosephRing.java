package Others;

import java.util.ArrayList;
import java.util.List;
/**
 * Լɪ�򻷣���֪n����(�Ա��1��2��3...n�ֱ��ʾ)Χ����һ��Բ����Χ��
 * �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;������һ�����ִ�1��ʼ������
 * ����m���Ǹ����ֳ���;���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
 * 
 * @param n	�˵�����
 * @param start	��ʼ��������ţ�start < n
 * @param m ���еı��(���Դ���n)
 */
public class JosephRing {
	
		public static void main(String[] args) {
			//50���ˣ��ӵ�һ���˿�ʼ��������3���˳���
			countThree(9, 0, 3);
		}
		
		private static void countThree(int n, int start, int m) {
			
			List<Integer> list = new ArrayList<Integer>();
			
			//��ʼ���б�
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			
			while (list.size() > 1) {
				//��ǰ�治����̭�������б�β��
				for (int j = 0; j < m-1; j++) {
					list.add(list.remove(start));
				}
				//��ӡ�������
				//System.out.println(list.remove(start));
				list.remove(start);//��̭��ֱ���Ƴ�
			}
			//��ӡ������µ����
			System.out.println(list.get(0));
		}
}
