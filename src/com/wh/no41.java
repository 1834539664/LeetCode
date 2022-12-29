package com.wh;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * @author WH
 * @version 1.0
 * @date 2022/12/29 11:26
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class no41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int find = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < find) {
                continue;
            } else if (nums[i] == find) {
                find++;
            } else if (nums[i] > find) {
                break;
            }
        }
        return find;
    }

    //官方解法:

    /**
     * 我们将数组中所有小于等于 00 的数修改为 N+1N+1；
     * <p>
     * 我们遍历数组中的每一个数 xx，它可能已经被打了标记，因此原本对应的数为 |x|∣x∣，其中 |\,|∣∣ 为绝对值符号。如果 |x| \in [1, N]∣x∣∈[1,N]，那么我们给数组中的第 |x| - 1∣x∣−1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；
     * <p>
     * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1N+1，否则答案是第一个正数的位置加 11。
     *
     * @param nums
     * @return 这个解法的本质是利用了不会出现的数一定在(1 - n + 1)之间, 而这恰好和数组的长度(n)关联了起来,
     * 利用数组的下标和数组的值作为标记,直接找到未出现的值
     */
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (Math.abs(nums[i]) >= 1 && Math.abs(nums[i]) <= len) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i]>0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}

class Test41 {
    @Test
    void test41() {
        int[] nums = {0,1,2};
        int i = new no41().firstMissingPositive2(nums);
        System.out.println(i);
    }
}