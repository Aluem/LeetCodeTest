package com.dynamic_programming.fibonaci;

//198. 打家劫舍
public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        int ans = rob.rob(new int[]{2, 7 ,9 , 3, 1});
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        int[] ans = new int[l];
        int tmp = 0;
        for (int i = 0; i < l; i++) {
            if (i - 2 >= 0) {
                tmp = ans[i - 2];
            }
            tmp = i - 3 >= 0 ? Math.max(tmp, ans[i - 3]) : tmp;
            ans[i] = nums[i] + tmp;
        }
        return Math.max(ans[l - 2], ans[l - 1]);
    }
}
