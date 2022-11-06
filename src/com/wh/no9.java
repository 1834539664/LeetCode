package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/4 21:45
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 */
public class no9 {
    //问题中要求不将整数转换成字符串,不符合要求
    public boolean isPalindrome(int x) {
        char[] chars = Integer.toString(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (revertedNumber < x) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertedNumber || revertedNumber / 10 == x;
    }
}


class Test9 {
    @Test
    void test9() {
        boolean b = new no9().isPalindrome2(1);
        System.out.println(b);
    }
}