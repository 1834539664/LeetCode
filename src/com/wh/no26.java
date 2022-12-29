package com.wh;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/14 20:34
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素只出现一次返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class no26 {
    //双指针解决
    //慢指针slow指向要返回的数组的最后一个位置
    //快指针fast遍历原数组
    //题中限定了nums.length>1 , 因此不做空判定
    public int removeDuplicates(int[] nums) {
        //如果只有一个元素,直接返回
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
