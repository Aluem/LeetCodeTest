package com.sort.review;

import java.util.Arrays;

//插入排序复习
public class InsertSort {

    public static void main(String[] args) {
       int[] nums = new int[] {5,2,3,1};
       new InsertSort().insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // i 到第几个元素开始插入
            int val = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > val) {
                nums[j + 1] = nums[j]; //后移
                j--;
            }
            j++; //j 复位
            nums[j] = val;
        }
    }


}
