package com.aluem;

import java.util.Arrays;

public class day10 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[] {2, 5, 6};
        int n = 3;
        day10 day10 = new day10();
        day10.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并两个有序数组 时间复杂度O(m+n) 空间复杂度O(m+n)
     * @param nums1 数组1
     * @param m 数组1有效数字长度
     * @param nums2 数组2
     * @param n 数组2有效数字长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNum = new int[m + n];
        for (int i = 0, j = 0; i + j < m + n;) {
            if (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    tempNum[i + j] = nums1[i];
                    i++;
                } else {
                    tempNum[i + j] = nums2[j];
                    j++;
                }
            } else if (i < m) {
                tempNum[i + j] = nums1[i];
                i++;
            } else if (j < n) {
                tempNum[i + j] = nums2[j];
                j++;
            }
        }
        for (int i = 0; i < tempNum.length; i++) {
            nums1[i] = tempNum[i];
        }
    }
}
