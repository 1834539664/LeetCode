package com.wh;

import org.junit.jupiter.api.Test;

/**
 * @author WH
 * @version 1.0
 * @date 2022/10/28 11:52
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
//思路:由于时间复杂度为O(log (m+n)) ,只能用二分查找
//寻找length/2最小的数,使用递归二分查找
public class no4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        double res = (findMid(nums1,0,m-1,nums2,0,n-1,left)+findMid(nums1,0,m-1,nums2,0,n-1,right))*0.5;
        return res;
    }

    /**
     * 使用递归寻找第k小的数
     *
     * @param nums1  长度较小的数组
     * @param start1 数组1左指针
     * @param end1   数组1 右指针
     * @param nums2
     * @param start2
     * @param end2
     * @param k      要寻找的第k小的数
     * @return
     */
    public int findMid(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int nums1Len = end1 - start1 + 1;
        int nums2Len = end2 - start2 + 1;
        //保证nums1的长度小于nums2
        if (nums1Len > nums2Len) {
            return findMid(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (nums1Len <= 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int m = k / 2;
        int i; //nums1指针
        int j = start2 + m - 1;//nums2 指针
        if (m > nums1Len) {
            i = end1;
        } else {
            i = start1 + m - 1;
        }
        if (nums1[i] >= nums2[j]) {
            return findMid(nums1, start1, end1, nums2, j + 1, end2, k - (j-start2+1));
        } else {
            return findMid(nums1, i + 1, end1, nums2, start2, end2, k-(i-start1+1));
        }
    }
}

class Test3{

    @Test
    public void test3(){
        int[] nums1 = {1};
        int[] mums2 = {2,3,4,5,6};
        double res = new no4().findMedianSortedArrays(nums1, mums2);
        System.out.println(res);
    }
}