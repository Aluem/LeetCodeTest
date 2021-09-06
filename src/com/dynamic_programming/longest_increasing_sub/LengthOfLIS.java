package com.dynamic_programming.longest_increasing_sub;

import java.util.Arrays;

//300.最长递增子序列
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len + 1; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
