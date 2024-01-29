package com.nathan.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 6953 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串
     * <p>
     * 一个回文去掉两头以后，剩下的部分依然是回文（这里暂不讨论边界情况）：
     * <p>
     * 如果一个字符串的头尾两个字符都不相等，那么这个字符串一定不是回文串；
     * 如果一个字符串的头尾两个字符相等，才有必要继续判断下去。
     * 如果里面的子串是回文，整体就是回文串；
     * 如果里面的子串不是回文串，整体就不是回文串。
     * 即：在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质，这就是状态转移。
     * 因此可以把「状态」定义为原字符串的一个子串是否为回文子串。
     * <p>
     * 第 1 步：定义状态
     * dp[i][j] 表示子串 s[i..j] 是否为回文子串，这里子串 s[i..j] 定义为左闭右闭区间，可以取到 s[i] 和 s[j]。
     * <p>
     * 第 2 步：思考状态转移方程
     * 在这一步分类讨论（根据头尾字符是否相等），根据上面的分析得到：
     * <p>
     * <p>
     * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     * 说明：
     * <p>
     * 「动态规划」事实上是在填一张二维表格，由于构成子串，因此 i 和 j 的关系是 i <= j ，因此，只需要填这张表格对角线以上的部分。
     * <p>
     * 看到 dp[i + 1][j - 1] 就得考虑边界情况。
     * <p>
     * 边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
     * <p>
     * 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，
     * 其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
     * <p>
     * 如果子串 s[i + 1..j - 1] 只有 1 个字符，即去掉两头，剩下中间部分只有 1 个字符，显然是回文；
     * 如果子串 s[i + 1..j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。
     * 因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下，直接可以下结论，dp[i][j] = true，否则才执行状态转移。
     * <p>
     * 第 3 步：考虑初始化
     * 初始化的时候，单个字符一定是回文串，因此把对角线先初始化为 true，即 dp[i][i] = true 。
     * <p>
     * 事实上，初始化的部分都可以省去。因为只有一个字符的时候一定是回文，dp[i][i] 根本不会被其它状态值所参考。
     * <p>
     * 第 4 步：考虑输出
     * 只要一得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，这是因为截取字符串也要消耗性能，
     * 记录此时的回文子串的「起始位置」和「回文长度」即可
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] ss = s.toCharArray();
        int left = 0;
        int lenMax = 1;
        boolean[][] dp = new boolean[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (ss[i] == ss[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // 记录回文的最大长度
                if (dp[i][j] && j - i + 1 > lenMax) {
                    lenMax = j - i + 1;
                    left = i;
                }
            }
        }
        return s.substring(left, left + lenMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
