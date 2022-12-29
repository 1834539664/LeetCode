package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/14 21:06
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，
 * 则返回-1 。
 */
public class no28 {
    //非常经典的kmp算法
    public int strStr(String haystack, String needle) {
        //构建next数组
        int len = needle.length();
        int[] next = new int[len];
        int j = 0; //j表示已找到的最长公共前后缀的长度,也表示计算next数组时即将匹配的字符的下标
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                next[i] = ++j;
            }
        }

        //根据next数组进行匹配
        for (int i = 0, k = 0; i < haystack.length(); i++) {
            while (k > 0 && haystack.charAt(i) != needle.charAt(k)) {
                k = next[k - 1];
            }
            if (haystack.charAt(i) == needle.charAt(k)) {
                k++;
            }
            if (k == len) {
                return i - len + 1;
            }
        }
        return -1;
    }
}
class Test28{
    @Test
    void test28(){
        //"ababcaababcaabc"
        //"ababcaabc"
        int i = new no28().strStr("ababcaababcaabc", "ababcaabc");
        System.out.println(i);
    }
}