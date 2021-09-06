package com.dynamic_programming.longest_increasing_sub;

import java.util.Arrays;

//376. 摆动序列
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[1] = 1;
        int preNegativeIdx = 0, prePositiveIdx = 0;// dp中上次负数出现的位置和正数出现的位置
        int sub;
        for (int i = 1; i < len; i++) {
            sub = nums[i] - nums[i - 1];
            if (sub > 0) {
                dp[i + 1] = dp[preNegativeIdx + 1] + 1;
                prePositiveIdx = i;
            } else if (sub < 0) {
                dp[i + 1] = dp[prePositiveIdx + 1] + 1;
                preNegativeIdx = i;
            } else {
                dp[i + 1] = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(nums[preNegativeIdx], nums[prePositiveIdx]);
    }
}
