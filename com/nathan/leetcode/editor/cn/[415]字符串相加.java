package com.nathan.leetcode.editor.cn;
/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode.cn/problems/add-strings/description/
 *
 * algorithms
 * Easy (54.59%)
 * Likes:    810
 * Dislikes: 0
 * Total Accepted:    313.4K
 * Total Submissions: 574.2K
 * Testcase Example:  '"11"\n"123"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= num1.length, num2.length <= 10^4
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 
 * 
 */

// @lc code=start
class Solution415 {
    /**
     * 竖式相加，从尾部字符（个位）开始处理，算出当前位结果后考虑进位
     * <p>
     * 时间复杂度：O(max⁡(len1,len2))，竖式加法的次数取决于较大数的位数
     * 空间复杂度：O(1)，在 Java 解法中使用到了 StringBuffer，故 Java 解法的空间复杂度为 O(n)
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || carry > 0) {
            // 防止越界
            int number1 = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
            int number2 = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
            // 当前位计算
            int target = number1 + number2 + carry;
            // 取余作为当前位的结果
            sb.append(target % 10);
            // 进位
            carry = target / 10;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

