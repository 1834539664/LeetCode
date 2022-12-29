package com.wh;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/24 18:33
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中
 * ，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，
 * 那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class no31 {
    //思路:在不考虑最大值情况下,我们每次返回比原来排列大的数组中最小的那一个,
    //即返回的数组需要满足两个条件:1.比原来的排列大 2.能返回的排列中的最小的
    //使用双指针
    public void nextPermutation(int[] nums) {
        int temp;
        int i = nums.length - 1;//i 指针指向最后一个元素
        int j = nums.length - 2; //j 指针指向倒数第二个元素
        while (i >= 0 && j >= 0 && nums[i] <= nums[j]) {
            if (i == j + 1) {
                j--;
                i = nums.length -1;
            } else {
                i--;
            }
        }
        //没有找到的情况,即已是最大排列
        if (j == -1) {
            //Arrays.sort(nums);//从小到大排列
            //return;
            exchange(nums,0,nums.length-1);
        } else {
            //交换
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            //但是,交换后并不确定这是能返回的最小情况,应该将j指针指向的元素后
            //的所有数字从小到大排列,这才是能返回的最小情况
            //刚交换后,除去交换的数字(j指针),剩下的数字组成的应该是排列最大的情况
            //直接首尾两两交换即可
            //int left = j + 1;
            //int right = nums.length - 1;
            //while (left < right) {
            //    temp = nums[left];
            //    nums[left] = nums[right];
            //    nums[right] = temp;
            //    left++;
            //    right--;
            //}
            exchange(nums,j+1,nums.length-1);
        }
    }
    //输入一个数组,左索引和右索引,连个索引之间的数(两边包含)将被首尾两两交换
    private void exchange(int[] nums,int left,int right){
        int temp;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}



class Test31 {
    @Test
    void test31() {
        //int[] nums = {3, 4, 232, 3, 1, 23};
        //Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        //[2,2,7,5,4,3,2,2,1]
        int nums[] ={2,2,7,5,4,3,2,2,1};
        new no31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}