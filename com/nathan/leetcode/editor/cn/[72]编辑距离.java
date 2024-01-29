package com.nathan.leetcode.editor.cn;
/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 *
 * https://leetcode.cn/problems/edit-distance/description/
 *
 * algorithms
 * Medium (62.79%)
 * Likes:    3274
 * Dislikes: 0
 * Total Accepted:    434.7K
 * Total Submissions: 692.1K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution72 {
    /**
     * 1. 确定dp数组（dp table）以及下标的含义
     * dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]
     *
     * 2. 确定递推公式
     * 在确定递推公式的时候，首先要考虑清楚编辑的几种操作，整理如下：
     *    if (word1[i - 1] == word2[j - 1])
     *        说明不用任何编辑，dp[i][j] 就应该是 dp[i - 1][j - 1]，即dp[i][j] = dp[i - 1][j - 1]
     *    if (word1[i - 1] != word2[j - 1])
     *        此时就需要编辑了，如何编辑呢？
     *
     * 操作一：
     * word1增加一个元素，使其word1[i - 1]与word2[j - 1]相同，那么就是以下标i-2为结尾的word1
     * 与 j-1为结尾的word2的最近编辑距离 加上一个增加元素的操作,即 dp[i][j] = dp[i - 1][j] + 1;
     *
     * 操作二：
     * word2添加一个元素，使其word1[i - 1]与word2[j - 1]相同，那么就是以下标i-1为结尾的word1
     * 与 j-2为结尾的word2的最近编辑距离 加上一个增加元素的操作,因为 word2添加一个元素，相当于word1
     * 删除一个元素，例如 word1 = "ad" ，word2 = "a"，word2添加一个元素d 和 word1删除一个元素d 操作数一样，
     * 即 dp[i][j] = dp[i][j - 1] + 1;
     *
     * 操作三：
     * 替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增加元素，那么以下标i-2为结尾
     * 的word1 与 j-2为结尾的word2的最近编辑距离 加上一个替换元素的操作， 即 dp[i][j] = dp[i - 1][j - 1] + 1;
     *
     * 综上即：dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1;
     *
     * 3. dp数组如何初始化
     *
     * dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
     *
     * dp[i][0] ：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]。则对空字符串做
     * 添加元素的操作即可得到另一个字符串，即：dp[i][0] = i，同理dp[0][j] = j;
     * */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

