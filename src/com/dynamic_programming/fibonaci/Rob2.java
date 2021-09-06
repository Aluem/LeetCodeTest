package com.dynamic_programming.fibonaci;

public class Rob2 {

    public static void main(String[] args) {
        Rob2 rob2 = new Rob2();
        rob2.rob(new int[] {2, 1, 1, 2});
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, nums.length - 2),robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int pre2 = nums[start], pre1 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

}
