package com.wh;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/26 9:29
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */

public class no32 {
    public int longestValidParentheses(String s) {
        //动态规划
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {//从1开始,直接排除长度<=1的情况
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i] + dp[i - 2];
                    }
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + dp[i - 1];
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    //写一个方法,用于判断当前字符串是否是有效括号字符串
    //有效返回true
    public boolean isCorrect(String s) {
        //利用栈,前面已经写过,不做赘述
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

class Test32 {
    @Test
    void test32() {
        String s = "(()())";
        int i = new no32().longestValidParentheses(s);
        System.out.println(i);

    }
}