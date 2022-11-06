package com.wh;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/6 22:23
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class no14 {
    //思路1:暴力破解,直接循环找长公共前缀
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = longestCommonPrefix(res, strs[i]);
        }
        return res;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int i = 0;
        String res = "";
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            res += str1.charAt(i);
            i++;
        }
        return res;
    }


}
