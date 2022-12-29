package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/26 18:38
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class no33 {
    //二分查找+递归
    public int search(int[] nums, int target) {
        return search2(nums, target, 0, nums.length - 1);
    }

    public int search2(int[] nums, int target, int left, int right) {
        if (target == nums[left]) {
            return left;
        }
        if (target == nums[right]) {
            return right;
        }
        int mid = (left + right) / 2;
        if (mid==left || mid ==left){
            return -1;
        }
        if (target == nums[mid]) {
            return mid;
        }
        if (mid > 0 && nums[left] <= nums[mid - 1]) {
            if (nums[left] < target && target <= nums[mid - 1]) {
                return search2(nums, target, left, mid - 1);
            } else {
                return search2(nums, target, mid + 1, right);
            }
        }
        if (mid + 1 < nums.length  && nums[mid + 1] <= nums[right]) {
            if (nums[mid + 1] <= target && target < nums[right]) {
                return search2(nums, target, mid + 1, right);
            } else {
                return search2(nums, target, left, mid - 1);
            }
        }
        return -1;
    }
}

class Test33 {
    @Test
    void test33() {
       //1.3
       // 0
        int[] nums = {1,3};
        int target = 0;
        int search = new no33().search(nums, target);
        System.out.println(search);
    }
}