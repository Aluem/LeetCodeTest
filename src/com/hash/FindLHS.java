package com.hash;

import java.util.HashMap;
import java.util.Map;

//594. 最长和谐子序列
public class FindLHS {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                ans = Math.max(ans, map.get(key) + map.get(key + 1));
        }
        return ans;
    }
}
