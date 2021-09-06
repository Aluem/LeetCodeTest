package com.search.backtracking;

//93. 复原 IP 地址

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("0000");
        System.out.println(strings);
    }

    List<String> res = new LinkedList<>();
    boolean[][][] isVisited; //记录ijk三个值
    //剪枝 + 记忆化搜索
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return res;
        isVisited = new boolean[s.length()][s.length()][s.length()];
        dfs(1, 2, 3, new StringBuilder(s));
        return res;
    }

    public void dfs(int i, int j, int k, StringBuilder s) {
        if (i >= j || j >= k || k >= s.length() || i > 3 || j > 6 || k > 9) return;
        if (isVisited[i][j][k]) return;
        //标记已访问
        isVisited[i][j][k] = true;
        String bac = s.toString();
        s.insert(i, '.');
        s.insert(j + 1, '.');
        s.insert(k + 2, '.');

        boolean flag = true;
        String[] s1 = s.toString().split("\\.");
        for (int l = 0; l < s1.length; l++) {
            if (s1[l].length() == 0 || Integer.parseInt(s1[l]) > 255 || (s1[l].charAt(0) == '0' && !s1[l].equals("0"))) {
               flag = false;
               break;
            }
        }
        if (flag)
            res.add(s.toString());
        dfs(i + 1, j, k, new StringBuilder(bac));
        dfs(i, j + 1, k, new StringBuilder(bac));
        dfs(i, j, k + 1, new StringBuilder(bac));
    }
}
