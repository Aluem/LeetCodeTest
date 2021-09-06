package com.binary_search;

//153. 寻找旋转排序数组中的最小值
public class FindMin {
    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) return nums[0];
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= nums[len - 1]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
