package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/5 22:02
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class no11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int temp;
        while (left < right) {
            temp = Integer.min(height[left], height[right]) * (right - left);
            if (temp > maxArea) {
                maxArea = temp;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        //美感爆炸的一段三元运算符
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}



class test11{

    @Test
    void test11(){
         int[] height= new int[]{1,8,6,2,5,4,8,3,7};
        int i = new no11().maxArea(height);
        System.out.println(i);
    }
}