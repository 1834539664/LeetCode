package com.wh;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author WH
 * @version 1.0
 * @date 2022/10/27 20:43
 */
//给定一个字符串 s 请你找出其中不含有重复字符的 最长子串的长度
public class no3 {
    //思路:利用集合ArrayList
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))){
                if (maxSize <list.size()){
                    maxSize = list.size();
                }
                int index = list.indexOf(s.charAt(i));
                for (int j = 0; j <= index; j++) {
                    list.remove(0);
                }
            }
                list.add(s.charAt(i));
        }
        if (maxSize<list.size()){
            maxSize=list.size();
        }
        return maxSize;
    }
}

class Test2{

    @Test
    void test(){
        String s = "aab";
        int i = new no3().lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}