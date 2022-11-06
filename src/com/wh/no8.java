package com.wh;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/4 20:03
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数
 * （类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 * 1.读入字符串并丢弃无用的前导空格
 * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
 * 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
 * 如果没有读入数字，则整数为 0。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，
 * 使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 231− 1
 * 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 */
public class no8 {
    public int myAtoi(String s) {
        final int MAX_VALUE = 2147483647;
        final int MIN_VALUE = -2147483648;
        int res = 0; //用来暂存结果
        char[] strArr = s.toCharArray();
        int[] resArr = new int[10];
        int strPosition = 0;
        int resPosition = 0;//记录resArr大小
        int flag = 1;
        //1.读入字符串并丢弃无用的前导空格
        for (int i = 0; i < strArr.length; i++) {
            if (strPosition < strArr.length && strArr[i] == ' ') {
                strPosition++;
            } else {
                break;
            }
        }
        //2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
        // 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        if (strPosition < strArr.length) {
            if (strArr[strPosition] == '-') {
                flag = -1;
                strPosition++;
            } else if (strArr[strPosition] == '+') {
                flag = 1;
                strPosition++;
            }
        }

        //3.省略数前面的0
        while (strPosition < strArr.length && strArr[strPosition] == '0') {
            strPosition++;
        }
        //读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
        while (strPosition < strArr.length && strArr[strPosition] >= '0' && strArr[strPosition] <= '9') {
            //超出int范围
            if (resPosition >= 10) {
                return flag == 1 ? MAX_VALUE : MIN_VALUE;
            }
            resArr[resPosition] = strArr[strPosition] - 48;
            strPosition++;
            resPosition++;
        }
        //对resArr判断是否超出范围
        boolean outOfIndex = false;
        if (resPosition == 10) {
            for (int i = 0; i < 10; i++) {
                if (flag == 1) {
                    String max = "" + MAX_VALUE;
                    if (max.charAt(i) - 48 > resArr[i]) {
                        break;
                    }
                    if (max.charAt(i) - 48 < resArr[i]) {
                        outOfIndex = true;
                        break;
                    }
                } else {
                    String min = "" + MIN_VALUE;
                    if (min.charAt(i + 1) - 48 > resArr[i]) {
                        break;
                    }
                    if (min.charAt(i + 1) - 48 < resArr[i]) {
                        outOfIndex = true;
                        break;
                    }
                }
            }
        }
        if (outOfIndex) {
            return flag == 1 ? MAX_VALUE : MIN_VALUE;
        } else {
            for (int i = 0; i < resPosition; i++) {
                res = res * 10 + resArr[i];
            }
            res *= flag;
        }
        return res;
    }

    //优化
    public int myAtoi2(String s) {
        char[] str = s.toCharArray();
        int res = 0;
        int i = 0;
        int flag = 1;
        //处理空字符串
        while (i<str.length && str[i] == ' ') {
            i++;
        }
        //处理正负号
        if (i<str.length &&str[i] == '-') {
            flag = -1;
        }
        if (i<str.length && (str[i] == '-' || str[i] == '+')) {
            i++;
        }
        //处理数字
        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            int r = str[i] - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            i++;
        }
        return flag > 0 ? res : -res;
    }
}


class test8 {
    @Test
    void test8() {
        int i = new no8().myAtoi2("");
        System.out.println(i);

    }
}