package com.arr;

import java.util.Arrays;

//283. 移动零
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 1, 2};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //双指针
    public void moveZeroes(int[] nums) {
        int len = nums.length, l = 0, r = 0;
        int tmp = 0;
        while (r < len) {
            if (nums[r] != 0) {
                tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
            r++;
        }
    }

    //=============================================
//    public void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == 0) {
//                //寻找下一个不为0的元素
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] != 0) {
//                        int tmp = nums[j];
//                        nums[j] = nums[i];
//                        nums[i] = tmp;
//                        break;
//                    }
//                }
//            }
//        }
//    }
}
