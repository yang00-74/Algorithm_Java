package com.nathan.dynamicplan;

import org.junit.Test;

public class Fibonacci509 {


	@Test
	public void test() {
		System.out.println("第二十个数是：" + fib2(2));
	}

	/**
	 * 斐波那契数列问题
	 * 动态规划：
	 * dp[i] = dp[i-1] + dp[i -2]
	 */
	public int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public int fib2(int n) {
		if (n <= 1) {
			return n;
		}
		int dp0 = 0;
		int dp1 = 1;
		for (int i = 2; i <= n; i++) {
			int tmp = dp0;
			dp0 = dp1;
			dp1 = tmp + dp1;
		}
		return dp1;
	}
}
