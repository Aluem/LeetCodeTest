package com.binary_search;

//540. 有序数组中的单一元素
public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {3,3,7,7,11,11,13};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }
}
