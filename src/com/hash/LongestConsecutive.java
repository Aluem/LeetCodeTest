package com.hash;

import java.util.HashSet;
import java.util.Set;

//128. 最长连续序列
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    //2.哈希表
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int tmp = i;
                while (set.contains(tmp + 1)) {
                    count++;
                    tmp++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }


    //================================================

//    //1.暴力法
//    public static int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        int max = 0;
//        for (Integer i : set) {
//            int count = 1;
//            int tmp = i;
//            while (set.contains(tmp + 1)) {
//                count++;
//                tmp++;
//            }
//            max = Math.max(max, count);
//        }
//        return max;
//    }
}
