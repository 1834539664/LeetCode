package com.wh;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/23 22:14
 * 给定一个字符串s 一个字符串数组words。words中所有字符串 长度相同。
 * <p>
 * s中的 串联子串 是指一个包含words中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，
 * "cdefab"，"efabcd"， 和"efcdab" 都是串联子串。"acdbef" 不是串联子串，
 * 因为他不是任何words排列的连接。
 * 返回所有串联字串在s中的开始索引。你可以以 任意顺序 返回答案。
 */
public class no30 {
    //思路:直接尝试暴力破解
    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wordLen = words[0].length() * words.length; //串联子串的长度
        List<Integer> list = new ArrayList<>(); //保存结果
        for (int i = 0; i < s.length(); i++) {//i表示s的匹配开始的索引
            if (sLen - i < wordLen) {
                break;
            }
            if (isMatch(s.substring(i, i + wordLen), words)) {
                list.add(i);
            }
        }
        return list;
    }

    //写一个方法,传入一个字符串和一个字符串数组,判断该字符串是否是该字符串数组的串联子串,两者总长度相等
    private boolean isMatch(String s, String[] words) {
        int wordLen = words[0].length();
        //List<String> list = Arrays.asList(words);//放入集合,方便操作
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));
        //转一下,因为Arrays.asList生成的ArrayList是Arrays的一个内部类,有很多方法没有重写,容易出错
        for (int i = 0; i < s.length(); i += wordLen) {
            String substring = s.substring(i, i + wordLen);
            int index = list.indexOf(substring);
            if (index == -1) {
                return false;
            } else {
                list.remove(index);
            }
        }
        return true;
    }
}

class Test30 {
    @Test
    void test30() {
        //"wordgoodgoodgoodbestword"
        //["word","good","best","good"]
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> list = new no30().findSubstring(s, words);
        System.out.println(list);
        //ArrayList<String> strings = new ArrayList<>();
        // strings.add("aaa");
        //strings.add("bbb");
        //strings.remove("aaa");
        //System.out.println(strings);
    }

}