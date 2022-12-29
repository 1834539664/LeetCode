package com.wh;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/11 8:21
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class no22 {
    //使用递归
    public List<String> generateParenthesis(int n) {
        Set<String> set = generateP(n);
        //将set集合转为list集合
        ArrayList<String> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    //set集合存放结果
    private Set<String> generateP(int n) {
        HashSet<String> newSet = new HashSet<>();

        //递归终止条件
        if (n == 1) {
            newSet.add("()");
            return newSet;
        }
        //调用递归
        Set<String> oldSet = generateP(n - 1);
        //将n-1个括号的处理结果与第n个括号结合
        //思路:针对set每一个元素,找到每一个"(",在"("右边插入一个"()",生成一个新的元素
        //此过程中有重复的,但是由于是set集合,会自动排重
        for (String s : oldSet) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    String newStr = s.substring(0, i+1) + "()" + s.substring(i+1);
                    newSet.add(newStr);
                }
            }
            //最后补一个特殊情况,在最左边添加一个括号
            String newStr = "()" + s;
            newSet.add(newStr);
        }
        return newSet;
    }
}

class Test22{
    @Test
    void test22(){
        List<String> list = new no22().generateParenthesis(3);
        System.out.println(list);
    }
}