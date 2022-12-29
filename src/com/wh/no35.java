package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/28 8:51
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class no35 {
    //二分查找
    public int searchInsert(int[] nums, int target) {
        //题目条件已经排除nums为空的情况,不再做判断
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right && left < nums.length && right >= 0) {
            mid = (left + right) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        //退出循环,方法未退出,说明未找到
        return target < nums[mid] ? mid : mid + 1;
    }
}

class Test35 {
    @Test
    void test() {
        int[] nums = {1, 3};
        int target = 2;
        int i = new no35().searchInsert(nums, target);
        System.out.println(i);
    }
}