package com.nathan.dynamicplan;

import java.util.Arrays;

/**
 * 数组模拟股票买卖，操作两次，求收益最大
 *    基本思想是分成两个时间段，然后对于某一天，计算之前的最大值和之后的最大值 
 * @author Administrator
 *
 */
public class CountArrayDP {

	public static void main(String[] args) {   
        int[] prices = {2,2,3,4,8,2,6};  
        System.out.println(maxProfit_k_2_dp(prices));
    }  
      
    public static int maxProfit(int[] prices) {  
        if(prices.length == 0){  
            return 0;  
        }  
          
        int max = 0;  
        // dp数组保存左边和右边的利润最大值  
        int[] left = new int[prices.length];     // 计算[0,i]区间的最大值  
        int[] right = new int[prices.length];   // 计算[i,len-1]区间的最大值  
          
        process(prices, left, right);  
          
        // O(n)找到最大值  
        for(int i=0; i<prices.length; i++){  
            max = Math.max(max, left[i]+right[i]);  
        }  
          
        return max;  
    }  
      
    public static void process(int[] prices, int[] left, int[] right){  
        left[0] = 0;  
        int min = prices[0];  // 最低买入价  
        //int[] prices = {2,2,3,4,8,2,6};
        // 左边递推公式，最低买入价获取的利润数组
        for(int i=1; i<left.length; i++){  
        // i的最大利润为（i-1的利润）和（当前卖出价和之前最小买入价之差）的较大那个
        	left[i] = Math.max(left[i-1], prices[i]-min);     
            min = Math.min(min, prices[i]);     // 更新最小买入价  
        }  
          
        right[right.length-1] = 0;    // 最高卖出价  
        int max = prices[right.length-1];     
        // 右边递推公式，最高卖出价格获取的利润数组
        for(int i=right.length-2; i>=0; i--){  
       // i的最大利润为（i+1的利润）和（最高卖出价和当前买入价之差）的较大那个  
        	right[i] = Math.max(right[i+1], max-prices[i]); 
            max = Math.max(max, prices[i]);     // 更新最高卖出价  
        }  
          
      System.out.println(Arrays.toString(left));
      System.out.println(Arrays.toString(right));

    }

    public static int maxProfit_k_2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }


    public static int maxProfit_k_2_dp(int[] prices) {
        int max_k = 2;
        int[][][] dp = new int[prices.length][max_k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= max_k; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][max_k][0];
    }


}
