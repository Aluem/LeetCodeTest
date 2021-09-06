package com.dynamic_programming.longest_increasing_sub;

import java.util.Arrays;
import java.util.Comparator;

//646. 最长数对链
public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int len = pairs.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);

//        for (int i = 0; i < len; i++) {
//            int idx = binarySearch(pairs, pairs[i][0]);
//            if (idx >= 0) {
//                dp[i + 1] = dp[idx + 1] + 1;
//            }
//        }
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0 ; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
                }
            }
        }
//        for (int i = 0; i < len; i++) {
//            System.out.println(Arrays.toString(pairs[i]));
//        }
        System.out.println(Arrays.toString(dp));
        return dp[len];
    }

    //找到最后一个尾比目标值小的数组的下标
    private int binarySearch(int[][] pairs, int num1) {
        int l = 0, r = pairs.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (pairs[mid][1] < num1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }
}
