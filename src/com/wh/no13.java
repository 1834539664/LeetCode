package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/5 23:07
 * 罗马数字转整数
 */
public class no13 {
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int res = 0;
        int position = 0; //s的指针
        for (int i = 0; i < symbols.length; i++) {
            int endIndex = Math.min(symbols[i].length()+position,s.length());
            while (symbols[i].equals(s.substring(position, endIndex))) {
                res += values[i];
                position += symbols[i].length();
                endIndex = Math.min(symbols[i].length()+position,s.length());
            }
            if (position >= s.length()) {
                break;
            }
        }
        return res;
    }

    //网上更好的写法
    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
class Test13{
    @Test
    void test13(){
        int i = new no13().romanToInt("III");
        System.out.println(i);
    }
}