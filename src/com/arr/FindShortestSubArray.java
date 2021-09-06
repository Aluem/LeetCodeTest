package com.arr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//697. 数组的度
public class FindShortestSubArray {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 1};
        findShortestSubArray(nums);
    }
    /*
        找到所有出现次数最多的数 找到其首次和最后一次出现的位置 答案为 首末位差值最小的数 + 1
     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int maxCnt = 0;
        for (Integer integer : map.keySet()) {
            maxCnt = Math.max(map.get(integer), maxCnt);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == maxCnt) {
                list.add(integer);
            }
        }
        int len = Integer.MAX_VALUE;
        for (Integer integer : list) {
            int i = 0, j = nums.length - 1;
            while (nums[i] != integer || nums[j] != integer) {
                if (nums[i] != integer) {
                    i++;
                }
                if (nums[j] != integer) {
                    j--;
                }
            }
            len = Math.min(j - i + 1, len);
        }
        return len;
    }
}
