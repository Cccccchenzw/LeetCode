package com.example.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L088 {
    //88.合并两个有序数组
    //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    //
    //请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    //
    //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    //示例 1：
    //
    //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //输出：[1,2,2,3,5,6]
    //解释：需要合并 [1,2,3] 和 [2,5,6] 。
    //合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
    //示例 2：
    //
    //输入：nums1 = [1], m = 1, nums2 = [], n = 0
    //输出：[1]
    //解释：需要合并 [1] 和 [] 。
    //合并结果是 [1] 。
    //示例 3：
    //
    //输入：nums1 = [0], m = 0, nums2 = [1], n = 1
    //输出：[1]
    //解释：需要合并的数组是 [] 和 [1] 。
    //合并结果是 [1] 。
    //注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 ={2,5,6};
        int[] merge = merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(merge));
        merge2(nums1, 3, nums2, 3);
    }

    //自己解法
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] num_res = new int[m];
//        int[] num_res2 = new int[n];
//        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0;i<nums1.length;i++) {
            if (m >= (i+1)) {
//                num_res[i] = nums1[i];
//                hashSet.add(nums1[i]);
                integers.add(nums1[i]);
            }
        }
        for (int i = 0;i<nums2.length;i++) {
            if (n >= (i+1)) {
//                num_res2[i] = nums2[i];
//                hashSet.add(nums2[i]);
                integers.add(nums2[i]);
            }
        }
        Collections.sort(integers);
        nums1 = new int[m+n];
        for (int i = 0;i<nums1.length;i++) {
            nums1[i] = integers.get(i);
//            nums1[i] = hashSet.iterator().next();
//            nums1[i] = Math.min(num_res[i],num_res2[i]);
//            if (num_res[m] <= num_res2[n]) {
//
//            } else {
//
//            }
        }
        return nums1;
    }

    //推荐的解法
    //按照归并排序合并数组的思路实现，但由于nums1数组已预留空间，所以倒序归并，无需tmp数组。
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            //利用已经排序了的数组，类似于双指针，谁大指针移动
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        //总有一个先为0，另一个则按照原有位置放入即可
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
