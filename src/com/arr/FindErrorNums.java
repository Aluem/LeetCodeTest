package com.arr;

import java.util.Arrays;

//645. 错误的集合
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0) {
                ans[0] = nums[i]; //重复
            }
            if (nums[i] - nums[i - 1] != 1) {
                if (i + 1 == nums[i]) {
                    ans[1] = i;
                } else {
                    ans[1] = i + 1; //missing
                }
            }
        }
        return ans;
    }
}
