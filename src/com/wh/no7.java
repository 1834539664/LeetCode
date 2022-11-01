package com.wh;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

import java.util.Stack;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/1 23:28
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
//思路,将数字转为字符串,存入栈中,再依次弹出,如果位数与最大整数位数相同,需要比较大小
    //效率极低,涉及多次的类型转换
public class no7 {
    public int reverse(int x) {
        final String MAX_VALUE = "2147483647";
        final String MIN_VALUE = "-2147483648";
        String s = Integer.toString(x);
        int start = 0;
        int k = 1;
        boolean outOfIndex = false;//判断是否越界
        //判断该数是一个正数还是负数
        if (s.charAt(0) == '-') {
            k = -1;
            start = 1;
        }
        if (s.charAt(0) == '+') {
            start = 1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = start; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        //判断是否越界,max=2,147,483,647 ,min = -2,147,483,648
        if (res.length() > MAX_VALUE.length()) {
            outOfIndex = true;
        }
        if (res.length() == MAX_VALUE.length()) {
            //是正数还是负数
            if (k == 1) {
                for (int i = 0; i < res.length(); i++) {
                    if (res.charAt(i) > MAX_VALUE.charAt(i)) {
                        outOfIndex = true;
                        break;
                    } else if (res.charAt(i) < MAX_VALUE.charAt(i)) {
                        break;
                    }
                }
            } else {
                for (int i = 0; i < res.length(); i++) {
                    if (res.charAt(i) > MIN_VALUE.charAt(i + 1)) {
                        outOfIndex = true;
                        break;
                    } else if (res.charAt(i) < MIN_VALUE.charAt(i+1)) {
                        break;
                    }
                }
            }
        }
        if (outOfIndex) {
            return 0;
        } else {
            String result = "0";
            if (k == -1) {
                result = "-" + res.toString();
            } else {
                result = res.toString();
            }
            return Integer.parseInt(result);

        }

    }
}

class Test7 {

    @Test
    void test7() {
        int i = new no7().reverse(-1563847412);
        System.out.println(i);
    }
}