package com.binary_search;

//34. 在排序数组中查找元素的第一个和最后一个位置
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ans = new int[] {-1, -1};
        if (len == 0) return ans;
        int l = 0, h = len - 1;
        //二分法找到最左边的
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            ans[0] = l;
            while (l + 1 < len && nums[l] == nums[l + 1]) {
                l++;
            }
            ans[1] = l;
        }
        return ans;
    }
}
