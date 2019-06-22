package Others;
import java.util.Stack;
/**
 * ����Ԫ�ؽ�ջ˳���жϳ�ջ�����Ƿ�Ϸ���
 * ��˼·������һ��������ջ������ѹջ˳���Ƚ���һ������ջ�У�������1��
 * Ȼ���ж�ջ��Ԫ���ǲ��ǳ�ջ˳��ĵ�һ��Ԫ�أ�������4������Ȼ1��4��
 * �������Ǽ���ѹջ��ֱ������Ժ�ʼ��ջ����ջһ��Ԫ�أ��򽫳�ջ�����±�����ƶ�һλ��
 * ֱ������ȣ�����ѭ����ѹջ˳�������ɣ��������ջ����Ϊ�գ�
 * ˵���������в��Ǹ�ջ�ĵ���˳��
������
��ջ1,2,3,4,5
��ջ4,5,3,2,1
����1�븨��ջ����ʱջ��1��4��������ջ2
��ʱջ��2��4��������ջ3
��ʱջ��3��4��������ջ4
��ʱջ��4��4����ջ4�������������һλ����ʱΪ5��,����ջ������1,2,3
 *
 */

public class StackPOPSequence {
   
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);//��ջ����
            while(!s.empty() &&s.peek() == popA[popIndex]){ 
                //���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
                s.pop();//��ջ
                popIndex++; //�����������һλ
            }
        }
        return s.empty();
    }
}