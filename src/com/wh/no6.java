package com.wh;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/1 22:59
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class no6 {
    //利用StringBuffer添加即可,此方法没有找规律,直接利用题意添加,效率较低
    public String convert(String s, int numRows) {

        StringBuffer[] mat = new StringBuffer[numRows];
        //初始化
        for (int i = 0; i < numRows; i++) {
            mat[i] = new StringBuffer();
        }
        int i = 0; //记录字符添加到二维数组的坐标
        int k = 0;//指针,指向s字符串中的字符
        while (k < s.length()) {
            i = 0;
            while (k < s.length() && i < numRows) {
                mat[i].append(s.charAt(k));
                k++;
                i++;
            }
            i = numRows - 2;
            while (k < s.length() && i > 0) {
                mat[i].append(s.charAt(k));
                k++;
                i--;
            }
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer row : mat) {
            res.append(row);
        }
        return res.toString();
    }
}

class Test6 {

    @Test
    void test6() {
        String s = new no6().convert("abcdabc", 3);
        System.out.println(s);
    }
}