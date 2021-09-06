package com.arr;

//287. 寻找重复数
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    //==============================================

//    //二分法
//    public int findDuplicate(int[] nums) {
//        int l = 1, r = nums.length - 1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            int cnt = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] <= mid) {
//                    cnt++;
//                }
//            }
//            if (cnt > mid) r = mid - 1;
//            else l = mid + 1;
//        }
//        return l;
//    }

    //==============================================
    //暴力 超时
//    public int findDuplicate(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return nums[i];
//                }
//            }
//        }
//        return -1;
//    }
}
