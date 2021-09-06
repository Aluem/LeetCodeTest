package com.search.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//46. 全排列
public class Permute {

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> res = new LinkedList<>();
    private boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        dfs(nums, new LinkedList<>());
        return res;
    }

    public void dfs(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) { //已经选择完所有值
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            list.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, list);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}
