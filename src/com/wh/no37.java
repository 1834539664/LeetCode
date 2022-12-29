package com.wh;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author WH
 * @version 1.0
 * @date 2022/12/26 9:14
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * <p>
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，
 * 每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，
 * 然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，
 * 再将所有描述组连接起来。
 */
public class no37 {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            //3322251,拆分字符串
            String[] strings = spiltString(result);
            result = "";
            for (int j = 0; j < strings.length; j++) {
                if (strings[j] == null) {
                    break;
                } else {
                    result += strings[j];
                }
            }
        }
        return result;
    }

    //拆分字符串方法
    public String[] spiltString(String s) {
        String[] strings = new String[s.length()];
        int index = 0;
        int i = 0;
        int j = 1;
        while (i < j && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            } else {
                strings[index] = j - i + "" + s.charAt(i);
                i = j;
                j++;
                index++;
            }
        }
        strings[index] = j - i + "" + s.charAt(i);
        return strings;
    }

    //简化
    public String countAndSay2(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            String newResult = "";
            int count = 0;
            char temp = result.charAt(0);
            for (int j = 0; j < result.length(); j++) {
                if (temp == result.charAt(j)) {
                    count++;
                } else {
                    newResult += count + "" + temp;
                    count = 1;
                    temp = result.charAt(j);
                }
            }
            newResult += count + "" + temp;
            result = newResult;
        }
        return result;
    }
}

class Test37 {
    @Test
    void test37() {
        //String[] strings = new no37().spiltString("1");
        //System.out.println(Arrays.toString(strings));
        String s = new no37().countAndSay2(4);
        System.out.println(s);
    }
}