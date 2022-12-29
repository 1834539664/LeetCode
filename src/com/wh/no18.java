package com.wh;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/10 22:03
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）
 */
public class no18 {
    //参考三数之和,双重循环+双指针解决
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Long targetNum = Long.valueOf(target);
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        ArrayList<List<Integer>> lists = new ArrayList<>();

        int first;
        int second;
        int third;
        int forth;
        Long tempTarget;

        for (first = 0; first < numsCopy.length-3; first++) {

            if (first > 0 && numsCopy[first] == numsCopy[first - 1]) {
                continue;
            }
            for (second = first + 1; second < numsCopy.length-2; second++) {
                if (second > first + 1 && numsCopy[second] == numsCopy[second - 1]) {
                    continue;
                }
                third = second + 1;
                forth = numsCopy.length - 1;
                tempTarget = targetNum - numsCopy[first] - numsCopy[second];
                for (third = second + 1; third < numsCopy.length-1; third++) {
                    if (third > second + 1 && numsCopy[third] == numsCopy[third - 1]) {
                        continue;
                    }
                    while (third < forth && numsCopy[third] + numsCopy[forth] > tempTarget) {
                        forth--;
                        while (third < forth && numsCopy[forth] == numsCopy[forth + 1]) {
                            forth--;
                        }

                    }
                    if (third >= forth) {
                        break;
                    }
                    if (numsCopy[third] + numsCopy[forth] == tempTarget) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numsCopy[first]);
                        list.add(numsCopy[second]);
                        list.add(numsCopy[third]);
                        list.add(numsCopy[forth]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}

class Test18 {

    @Test
    void test18() {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        //[1000000000,1000000000,1000000000,1000000000]
        //-294967296
        List<List<Integer>> lists = new no18().fourSum(nums, -294967296);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}