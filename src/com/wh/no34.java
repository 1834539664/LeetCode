package com.wh;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/27 19:21
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 */
public class no34 {
    //要求复杂度O(log n),且数组有序,自热想到了二分查找,只要查找到一个值,在向左向右查找,就可以得到答案
    //使用循环+二分查找
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstOrLast(nums, target, true);
        int last = findFirstOrLast(nums, target, false);
        return new int[]{first, last};
    }

    private int findFirstOrLast(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;
        int targetIndex = -1;//如果找到了就存在targetIndex
        while (left <= right && left < nums.length && left >= 0 && right < nums.length && right >= 0) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                targetIndex = mid;
                if (first == true) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return targetIndex;
    }
}

class Test34 {
    @Test
    void test34() {
        int[] nums = {2, 2};
        int target = 2;
        int[] res = new no34().searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
