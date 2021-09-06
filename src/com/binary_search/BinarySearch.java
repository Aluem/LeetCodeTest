package com.binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        //寻找最左边的2
        int[] nums = new int[] {1,1,1,2,2,3,4,6,7,8,8,8,16,17};
        System.out.println(binarySearch(6, nums));
    }

    //二分查找，返回目标值的下标
    public static int binarySearch(int target, int nums[]) {
        int l = 0, h = nums.length - 1;
        while (l < h) { //边界条件待处理
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l == h);
        return h;
    }
}
