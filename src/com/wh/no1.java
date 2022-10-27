package com.wh;

import java.util.HashMap;

/**
 * @author WH
 * @version 1.0
 * @date 2022/10/27 19:13
 * 在数组中查找数
 */
public class no1 {
    /*要求:
    给定一个整数数组 nums[]和一个整数目标值 target，请你在该数组中找出和为目标值target的那两个整数,并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    */

    //思路1:双重循环遍历解决,时间复杂度O(n2)
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return null;
    }
    //思路2:使用hash表
    public int[] twoSum2(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
