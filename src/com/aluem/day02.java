package com.aluem;

import java.util.*;

/**
 * author aluem
 * day 2021-03-27
 * <p>
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class day02 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }


    /**
     * 解法一：递归
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        dfs(nums, 0, len, new Stack<>(), res);
        return res;
    }

    private static void dfs(int[] nums,int index ,int len, Stack<Integer> stack, List<List<Integer>> res) {
        if (index == len) { //已经挑选到了最后一个元素的后一位
            res.add(new ArrayList<>(stack));
            return;
        }
        //选择不添加当前index的元素
        dfs(nums, index + 1, len, stack, res);

        //添加当前index的元素
        stack.push(nums[index]);
        dfs(nums, index + 1, len, stack, res);
        stack.pop();
    }


}
