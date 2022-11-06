package com.wh;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/4 22:07
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 */
public class no10 {
    //暴力破解法,直接循环破解,暂时失败,需要考虑的情况太多,代码的可读性极差
    //暂时失败匹配"bbbba",".*a*a"
    public boolean isMatch(String s, String p) {
        int sIndex = 0;//指向s的指针
        int pIndex = 0;//指向p的指针
        while (sIndex < s.length() && pIndex < p.length()) {
            if (p.charAt(pIndex) == '.') {
                sIndex++;
                pIndex++;
            } else if (p.charAt(pIndex) == '*') {
                char c = p.charAt(pIndex - 1);
                while (sIndex < s.length() && (c == s.charAt(sIndex) || c == '.') && s.length() - sIndex >= p.length() - pIndex) {
                    sIndex++;
                }
                pIndex++;
            } else {
                if (s.charAt(sIndex) == p.charAt(pIndex)) {
                    sIndex++;
                    pIndex++;
                } else if (pIndex+1<p.length() && p.charAt(pIndex + 1) == '*') {
                    pIndex++;
                } else {
                    return false;
                }
            }
        }
        if (sIndex == s.length() && pIndex == p.length() || (p.length()-pIndex==2) && p.charAt(pIndex+1)=='*'){
            return true;
        }else {
            return false;
        }
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
class Test10 {
    @Test
    void test10() {
        //"bbbba"
        //".*a*a"
        //boolean match = new no10().isMatch("bbbba", ".*a*a");
        //System.out.println(match);
        boolean b = new Solution().isMatch("AAABCAAB", "A*B.A*B");
        System.out.println(b);
    }

}