package com.dynamic_programming.arr_interval_sum;

class NumArray {
    private int[] nums;
    private int[] dp;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[0] = nums[0];
            else dp[i] = dp[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return dp[right] - dp[left] + nums[left];
    }
}