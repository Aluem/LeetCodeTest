package com.search.backtracking;

import java.util.*;

//131
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
//回文串 是正着读和反着读都一样的字符串。
public class Partition {

    public static void main(String[] args) {
        Partition partition = new Partition();
        List<List<String>> aab = partition.partition("abbab");
        System.out.println(aab);
    }

    private List<String> temp = new LinkedList<>();
    private List<List<String>> ans = new LinkedList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return ans;
    }

    private void dfs(int start, String s) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String t = s.substring(start, i + 1);
            if (isPartition(t)) {
                temp.add(t);
                dfs(i + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    //判断是否是回文串
    private boolean isPartition(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != (s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


//    private List<String> temp = new LinkedList<>();
//    private List<List<String>> ans = new LinkedList<>();
//    private Set<String> set = new HashSet<>();
//
//    public List<List<String>> partition(String s) {
//        for (int i = s.length() - 1; i >= 0; i--) { //将字符串切多少次
//            dfs(0, s, i);
//        }
//        return ans;
//    }
//
//    //回溯遍历
//    private void dfs(int start, String s, final int cutSize) {
//        if (temp.size() + s.length() - start < cutSize + 1) return;
//        if (cutSize == 0) {
//            //已经切完,将剩余的加入
//            String end = s.substring(start);
//            if (!end.equals("")){
//                temp.add(end);
//            }
//            if (allIsPartition()) {
//                ans.add(new ArrayList<>(temp));
//            }
//            if (!end.equals("")) {
//                temp.remove(temp.size() - 1);
//            }
//            return;
//        }
//        for (int i = start; i < s.length() - 1; i++) {
//            String tempS = s.substring(start, i + 1);
//            if (set.contains(tempS)) continue;
//            temp.add(tempS);
//            dfs(i + 1, s, cutSize - 1);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//    private boolean allIsPartition() {
//        for (String s : temp) {
//            if (!isPartition(s)) {
//                set.add(s);
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //判断是否是回文串
//    private boolean isPartition(String s) {
//        int l = 0, r = s.length() - 1;
//        while (l < r) {
//            if (s.charAt(l) != (s.charAt(r))) {
//                return false;
//            }
//            l++;
//            r--;
//        }
//        return true;
//    }


//    private List<String> temp = new LinkedList<>();
//    private List<List<String>> ans = new LinkedList<>();
//    public List<List<String>> partition(String s) {
//        dfs(0, s);
//        return ans;
//    }
//
//    //回溯遍历
//    private void dfs(int start, String s) {
//        for (int i = start; i < s.length(); i++) {
//            temp.add(s.charAt(i) + "");
//            ans.add(new ArrayList<>(temp));
//            dfs(i + 1, s);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//    //判断是否是回文串
//    private boolean isPartition() {
//        return false;
//    }

}
