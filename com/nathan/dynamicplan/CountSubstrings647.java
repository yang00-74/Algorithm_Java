package com.nathan.dynamicplan;

public class CountSubstrings647 {

    /**
     * 1. 确定dp数组（dp table）以及下标的含义
     * 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，
     * 如果是dp[i][j]为true，否则为false。
     *
     * 2. 确定递推公式
     * 当s[i]与s[j]不相等，dp[i][j]一定是false。
     *
     * 当s[i]与s[j]相等时有如下三种情况
     *
     * 情况一：下标i 与 j相同，同一个字符例如a，是回文子串
     * 情况二：下标i 与 j相差为1，例如aa，也是回文子串
     * 情况三：下标i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
     * i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，
     * 这个区间是不是回文就看dp[i + 1][j - 1]是否为true
     *
     * 3. 数组如何初始化
     * 刚开始就全都匹配不上，所以dp[i][j]初始化为false。
     *
     * 4. 确定遍历顺序
     * 从递推公式中可以看出，情况三是根据dp[i + 1][j - 1]是否为true，再对dp[i][j]进行赋值
     *
     * dp[i + 1][j - 1] 在 dp[i][j]的左下角，如果从上到下，从左到右遍历，那么会用到没有计算过的
     * dp[i + 1][j - 1]，也就是根据不确定是不是回文的区间[i+1,j-1]，来判断[i,j]是不是回文，那结果一定不对。
     * 所以要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的
     *
     * */
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return res;
    }
}
