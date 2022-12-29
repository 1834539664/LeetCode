package com.wh;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/14 20:56
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入
 */
public class no27 {
    //同26基本一样的写法
    //直接双指针解决
    public int removeElement(int[] nums, int val) {
        int slow = -1; //指向返回结果的最后一个元素
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
