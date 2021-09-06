package com.search.backtracking;

import java.util.*;

//40. 组合总和 II
public class CombinationSum2 {

    public static void main(String[] args) {
//        List<List<Integer>> lists = new CombinationSum2().combinationSum2(new int[]{1, 1, 7, 3}, 8);
        List<List<Integer>> lists = new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }

        private List<Integer> temp = new LinkedList<>();
        private List<List<Integer>> ans = new LinkedList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(0, candidates, target, new boolean[candidates.length]);
            return ans;
        }

        private void dfs(int start, int[] candidates, int target, boolean[] hasVisited) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
                return;
            }
//            if (target < 0 || start >= candidates.length) return;
            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && candidates[i - 1] == candidates[i] && !hasVisited[i - 1]) continue;
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    hasVisited[i] = true;
                    dfs(i + 1, candidates, target - candidates[i], hasVisited);
                    hasVisited[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
}
