package com.dynamic_programming.arr_interval_sum;

import java.util.Arrays;

//413. 等差数列划分
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length;
        if (l <= 2) return 0;
        int[] ans = new int[l]; // 记录答案
        int[] dp = new int[l + 1]; // 长度为下标的等差数列有多个的子数列

        ans[0] = 0;
        ans[1] = 0;
        Arrays.fill(dp, 0);
        int sub = nums[1] - nums[0];
        int tmp = 2; // 记录当前等差数列长度
        int preSub = 0; //上一次等差数列末尾下标
        for (int i = 2; i < l; i++) {
            if (nums[i] - nums[i - 1] == sub) {
                tmp++;
                dp[tmp] = dp[tmp - 1] + tmp - 2; //dp[3] = dp[2] + 3 - 2  dp[4] = dp[3] + 4 - 2
            } else {
                preSub = i - 1;
                tmp = 2; // 重置当前等差数列长度
                sub = nums[i] - nums[i - 1];
            }
            ans[i] = ans[preSub] + dp[tmp];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(ans));
        return ans[l - 1];
    }
}
