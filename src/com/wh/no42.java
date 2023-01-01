package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/12/30 16:48
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，
 * 在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class no42 {

    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                left = i;
                break;
            }
        }
        for (int i = left + 1; i < height.length; i++) {
            if (height[i] > 0) {
                if (height[left] > height[i]) {
                    for (int j = left + 1; j < i; j++) {
                        if (height[j] < height[i]) {
                            res += height[i] - height[j];
                            height[j] = height[i];
                        }
                    }
                } else {
                    for (int j = left + 1; j < i; j++) {
                        if (height[j] < height[left]) {
                            res += height[left] - height[j];
                            height[j] = height[left];
                        }
                    }
                    left = i;
                }
            }
        }
        return res;
    }
}

class Test42 {
    @Test
    void test42() {
        int[] height = {0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2};
        int trap = new no42().trap(height);
        System.out.println(trap);
    }
}