package com.aluem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解法二、回溯
 */
public class day02case2 {
    List<List<Integer>> result = new ArrayList<>();
    int n;

    /**
     * 运行一次能够构造所有长度为k的子集
     * @param start 子集第一个数在nums中最早可以出现的位置
     * @param k 当前需要构造子集的长度
     * @param cur 储存当前正在构造的子集
     * @param nums
     */
    public void backtrack(int start, int k, ArrayList<Integer> cur, int[] nums) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(nums[i]);
            backtrack(i+1, k-1, cur, nums);
            cur.remove(cur.size() - 1);//把这步加入到数字从数组中移除
        }
    }
}
