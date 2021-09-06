package com.search.backtracking;

import java.util.*;

//77. 组合
public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> combine = new Combine().combine(4, 2);
        System.out.println(combine);
    }
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        if (k == 0) return;
        if (temp.size() + (n - cur + 1)  < k) return;
        if (temp.size() == k) { //长度满足需求，添加到答案队列中
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i <= n; i++) {
            temp.add(i);
            dfs(i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}
