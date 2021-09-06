package com.search.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//39. 组合总和
public class CombinationSum {

    private List<Integer> temp = new LinkedList<>();
    private List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, 0, candidates, target);
        return ans;
    }

    private void dfs(int i, int curSum,int[] candidates, int t) {
        if (curSum > t) return;
        if (curSum == t) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            temp.add(candidates[j]);
            dfs(j, curSum + candidates[j], candidates, t);
            temp.remove(temp.size() - 1);
        }
    }
}
