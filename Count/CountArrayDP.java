package Count;

import java.util.Arrays;

/**
 * ����ģ���Ʊ�������������Σ����������
 *    ����˼���Ƿֳ�����ʱ��Σ�Ȼ�����ĳһ�죬����֮ǰ�����ֵ��֮������ֵ 
 * @author Administrator
 *
 */
public class CountArrayDP {

	public static void main(String[] args) {   
        int[] prices = {2,2,3,4,8,2,6};  
        System.out.println(maxProfit(prices));  
    }  
      
    public static int maxProfit(int[] prices) {  
        if(prices.length == 0){  
            return 0;  
        }  
          
        int max = 0;  
        // dp���鱣����ߺ��ұߵ��������ֵ  
        int[] left = new int[prices.length];     // ����[0,i]��������ֵ  
        int[] right = new int[prices.length];   // ����[i,len-1]��������ֵ  
          
        process(prices, left, right);  
          
        // O(n)�ҵ����ֵ  
        for(int i=0; i<prices.length; i++){  
            max = Math.max(max, left[i]+right[i]);  
        }  
          
        return max;  
    }  
      
    public static void process(int[] prices, int[] left, int[] right){  
        left[0] = 0;  
        int min = prices[0];  // ��������  
        //int[] prices = {2,2,3,4,8,2,6};
        // ��ߵ��ƹ�ʽ���������ۻ�ȡ����������
        for(int i=1; i<left.length; i++){  
        // i���������Ϊ��i-1�����󣩺ͣ���ǰ�����ۺ�֮ǰ��С�����֮��Ľϴ��Ǹ�
        	left[i] = Math.max(left[i-1], prices[i]-min);     
            min = Math.min(min, prices[i]);     // ������С�����  
        }  
          
        right[right.length-1] = 0;    // ���������  
        int max = prices[right.length-1];     
        // �ұߵ��ƹ�ʽ����������۸��ȡ����������
        for(int i=right.length-2; i>=0; i--){  
       // i���������Ϊ��i+1�����󣩺ͣ���������ۺ͵�ǰ�����֮��Ľϴ��Ǹ�  
        	right[i] = Math.max(right[i+1], max-prices[i]); 
            max = Math.max(max, prices[i]);     // �������������  
        }  
          
      System.out.println(Arrays.toString(left));  
      System.out.println(Arrays.toString(right));  
    }  
}
