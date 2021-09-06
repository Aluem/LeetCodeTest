package com.sort;

import java.util.Arrays;

//按颜色进行排序
public class SortColors {

    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {2, 0, 1};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //单指针
//    public void sortColors(int[] nums) {
//        int boundary = 0;
//        for (int i = 0; i < 2; i++) { //两轮遍历 第一轮将0交换到前面 第二轮将1交换到前面
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] == i) {
//                    swap(boundary, j, nums);
//                    boundary++;
//                }
//            }
//        }
//    }

    //双指针
    public void sortColors(int[] nums) {
        int boundary01 = 0;
        int boundary12 = nums.length - 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                swap(boundary01, j, nums);
                boundary01++;
            }
            if (nums[j] == 2 && j < boundary12) {
                swap(boundary12, j, nums);
                boundary12--;
                j--;
            }
        }
    }

    //三边
//    public void sortColors(int[] nums) {
//        int num0 = 0, num1 = 0, num2 = 0;
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] == 0) {
//                nums[num2++] = 2;
//                nums[num1++] = 1;
//                nums[num0++] = 0;
//            }else if(nums[i] == 1) {
//                nums[num2++] = 2;
//                nums[num1++] = 1;
//            }else {
//                nums[num2++] = 2;
//            }
//        }
//    }

    public void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
