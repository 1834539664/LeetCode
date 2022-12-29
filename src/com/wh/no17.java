package com.wh;

import com.sun.corba.se.pept.transport.ListenerThread;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.StringHolder;

import java.util.*;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/8 20:32
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class no17 {
    //队列(广度优先)
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        HashMap<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        //queue用来运算
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            merge(queue, map.get(digits.charAt(i)));
        }
        return queue;
    }

    //编写一个方法,将queue中的元素与传进来的字符串,并返回到queue
    private void merge(LinkedList<String> queue, String s) {
        if (queue.size() == 0) {
            for (int i = 0; i < s.length(); i++) {
                queue.add(String.valueOf(s.charAt(i)));
            }
            return;
        }
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            String pop = queue.pop();
            for (int j = 0; j < s.length(); j++) {
                queue.add(pop + s.charAt(j));
            }
        }

    }

    //回溯(深度优先)
    public List<String> letterCombinations2(String digits) {
        int len = digits.length();
        HashMap<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        if (len == 0) {
            return new ArrayList<>();
        } else {
            return merge2(map, 0, digits);
        }

    }

    //编写一个方法,该方法可以进行回溯拼接
    private List<String> merge2(HashMap<Character, String> map, int depth, String digits) {
        ArrayList<String> newRes = new ArrayList<>();
        if (depth == digits.length()) {
            newRes.add("");
            return newRes;
        }
        List<String> res = merge2(map, depth + 1, digits);
        //将当前元素与后面的元素拼接
        String s = map.get(digits.charAt(depth));
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < res.size(); j++) {
                newRes.add(s.charAt(i) + res.get(j));
            }
        }
        return newRes;
    }
}


class Test17 {
    @Test
    void test17() {
        List<String> list = new no17().letterCombinations2("23");
        System.out.println(list);
    }
}