package com.example.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class L026 {
    public static void main(String[] args) {
        //26.删除有序数组中的重复项
        //给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
        //
        //考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
        //
        //更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
        //返回 k 。
        //示例 1：
        //
        //输入：nums = [1,1,2]
        //输出：2, nums = [1,2,_]
        //解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
        //示例 2：
        //
        //输入：nums = [0,0,1,1,1,2,2,3,3,4]
        //输出：5, nums = [0,1,2,3,4]
        //解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
        int[] nums = {-3,-1,0,0,0,3,3};
        removeDuplicates(nums);
    }

    //完成了题意，但是效率低 5ms
    public static int removeDuplicates(int[] nums) {
        if (nums.length <=1) return nums.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num:nums){
            hashSet.add(num);
        }
        int i = 0;
        List<Integer> arrayList = new ArrayList<>(hashSet);
        Collections.sort(arrayList);
        for (;i<arrayList.size();i++){
            nums[i] = arrayList.get(i);
        }
        return i;
    }

    //19ms 效率更低
    public static int removeDuplicates2(int[] nums) {
        if (nums.length <=1) return nums.length;
        List<Integer> arrayList = new ArrayList<>();
        for (int num:nums){
            if (!arrayList.contains(num)) arrayList.add(num);
        }
        Collections.sort(arrayList);
        for (int i = 0;i<arrayList.size();i++){
            nums[i] = arrayList.get(i);
        }
        return arrayList.size();
    }

    //推荐解法
    public static int removeDuplicates3(int[] nums) {
        //快慢指针，j是慢指针
        int j = 0;
        for(int i=0;i< nums.length;i++) {
            if(nums[j] != nums[i]) {
                //找到了不相同的，将慢指针的下一个位置赋值快指针的值
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

    public static int removeDuplicates4(int[] nums) {
        int slow = 0;
        for (int fast = 0;fast<nums.length;fast++) {
            if (nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }

}
