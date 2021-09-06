package com.greedy;

//665. 非递减数列
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 5, 6, 9, 11, 17};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        boolean update = false;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] >= nums[i - 1]) {
                i++;
                continue;
            }
            if (update) return false;
            //优先考虑 nums[i-1] = nums[i] 此操作不会影响后面的数值 只需判断前面的数值
            //其次考虑 nums[i] = nums[i+1]
            //(i - 2 >= 0 && nums[i] >= nums[i - 2]) || i - 2 < 0
            if (i - 2 < 0 || nums[i] >= nums[i - 2] || i + 1 >= nums.length) {
                nums[i - 1] = nums[i];
            } else {
                nums[i] = nums[i + 1];

                if (nums[i] < nums[i - 1]) return false;
            }
            update = true;
            i++;
        }
        return true;
    }
}
