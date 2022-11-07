package com.wh;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/7 19:47
 */
public class no16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 10000000;
        int temp;
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    third--;
                    while (third < second && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else {
                    second++;
                    while (second > third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                }
            }
        }
        return best;
    }
}
