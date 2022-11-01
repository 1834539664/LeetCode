package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/1 22:40
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
//思路:动态规划(官方解法)
public class no5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2){
            return s;
        }

        int maxLen = 1;
        int begin  = 0;
        //dp[i][j] 表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        //初始化,所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }

        char[] charArray = s.toCharArray();
        //递推开始
        //先枚举子串长度
        for (int L = 2; L <= len; L++) {
            //枚举左边界
            for (int i = 0; i < len; i++) {
                //由L和i可以确定右边界
                int j = L+i-1;
                //如果右边界越界,就可以退出当前循环
                if (j>=len){
                    break;
                }
                if (charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else {
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                //只要dp[i][j] == true 成立,就表示s[i...L]是回文,此时记录回文长度和起始位置
                if (dp[i][j] && j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}

class Test5{
    @Test
    void test5(){
        String s = new no5().longestPalindrome("bb");
        System.out.println(s);
    }
}