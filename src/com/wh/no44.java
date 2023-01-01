package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2023/1/1 13:35
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 */
public class no44 {
    //动态规划
    public boolean isMatch(String s, String p) {
        int i = s.length();
        int j = p.length();
        boolean[][] dp = new boolean[i + 1][j + 1];
        //初始化
        dp[0][0] = true;
        for (int k = 1; k < j + 1; k++) {
            if (p.charAt(k - 1) == '*') {
                dp[0][k] = true;
            } else {
                break;
            }
        }

        for (int k = 1; k < i + 1; k++) {
            for (int l = 1; l < j + 1; l++) {
                if (s.charAt(k-1) == p.charAt(l-1) || p.charAt(l-1) == '?') {
                    dp[k][l] = dp[k - 1][l - 1];
                } else if (p.charAt(l-1) == '*') {
                    dp[k][l] = dp[k][l - 1] || dp[k - 1][l];
                }
            }
        }
        return dp[i][j];
    }
}
class Test44{
    @Test
    void test44(){

        boolean match = new no44().isMatch("aa", "*");
        System.out.println(match);
    }
}