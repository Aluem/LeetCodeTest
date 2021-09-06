package com.search.backtracking;

import java.util.*;

//47. 全排列 II
public class PermuteUnique {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, new LinkedList<>(), isVisited);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] isVisited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i > 0 && nums[i - 1] == nums[i] && !isVisited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, res, list, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }

    //==========================================================
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        boolean[] isVisited = new boolean[nums.length];
//        List<List<Integer>> res = new LinkedList<>();
//        dfs(nums, res, new LinkedList<>(), isVisited);
//        Set<List<Integer>> set = new HashSet<>();
//        set.addAll(res);
//        return new ArrayList(Arrays.asList(set.toArray()));
//    }
//
//    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] isVisited) {
//        if (list.size() == nums.length) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (isVisited[i]) {
//                continue;
//            }
//            list.add(nums[i]);
//            isVisited[i] = true;
//            dfs(nums, res, list, isVisited);
//            list.remove(list.size() - 1);
//            isVisited[i] = false;
//        }
//    }
}
