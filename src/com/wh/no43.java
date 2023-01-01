package com.wh;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author WH
 * @version 1.0
 * @date 2023/1/1 9:21
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class no43 {
    //思路:乘法竖式法
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int carry = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            String res = "";
            for (int j = num1.length() - 1; j >= 0; j--) {
                int i1 = num1.charAt(j) - '0';
                int i2 = num2.charAt(i) - '0';
                int temp = i1 * i2 + carry;
                if (j != 0) {
                    carry = temp / 10;
                    res = res + (temp % 10);
                } else {
                    res = res + (temp%10) +(temp/10==0?"":temp/10);
                    carry = 0;
                }
            }
            list.add(res);
        }
        //对list进行处理
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                String s = "0" + list.get(i);
                list.set(i, s);
            }
        }
        //相加
        String result = "";
        int size = list.get(list.size() - 1).length();
        int tempCarry = 0;
        for (int i = 0; i < size; i++) {
            int temp = tempCarry;
            for (int j = 0; j < list.size(); j++) {
                if (i<list.get(j).length()){
                    temp += (list.get(j).charAt(i) - '0');
                }
            }
            if (i<size-1){
                result = (temp % 10) + result;
                tempCarry=temp / 10;
            }else {
                result = temp + result;
            }
        }
        return result;
    }
}

class Test43{
    @Test
    void test43(){
        //"2"
        //"3"
        String num1 = "2";
        String num2 = "3";
        String multiply = new no43().multiply(num1, num2);
        System.out.println(multiply);
    }
}