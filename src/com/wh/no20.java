package com.wh;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/10 23:50
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class no20 {
    //利用栈保存所有的左括号,遇到右括号就取出比较,如果不匹配就返回false,读完字符串仍没有返回就返回true
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    Character pop = stack.pop();
                    if (!((pop == '(' && c == ')') || (pop == '[' && c == ']') || (pop == '{' && c == '}'))) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

class Test20 {
    @Test
    void test20() {
        boolean valid = new no20().isValid("()[]{}");
        System.out.println(valid);
    }
}