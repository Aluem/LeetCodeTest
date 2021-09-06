package com.search.backtracking;

import java.util.Map;

//97. 交错字符串
public class IsInterleave {

    int l1, l2, l3;
    String s1, s2, s3;
    boolean[][] visited;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();

        if (l1 + l2 != l3)  return false;
        visited = new boolean[l1 + 1][l2 + 1];

        return dfs(0, 0, 0);
    }

    public boolean dfs(int i, int j, int k) {
        if (k == l3) return true;
        if (visited[i][j])  return false;
        visited[i][j] = true;
        if (i < l1 && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1))         return true;
        if (j < l2 && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1))         return true;
        return false;
    }


//    public static void main(String[] args) {
//        IsInterleave isInterleave = new IsInterleave();
//        isInterleave.isInterleave("aabca", "dbbca","aadbbcbcac");
//        System.out.println(isInterleave.ans);
//    }
//
//    private String s1;
//    private String s2;
//    private String s3;
//    private boolean ans;
//    private StringBuilder sb = new StringBuilder();
//    boolean[][] visited;
//    public boolean isInterleave(String s1, String s2, String s3) {
//        this.s1 = s1;
//        this.s2 = s2;
//        this.s3 = s3;
//        if (s1.length() + s2.length() != s3.length()) return false;
//        visited = new boolean[s1.length()][s2.length()];
//        dfs(0, 0, 0);
//        return ans;
//    }
//
//    public void dfs(int i1, int i2, int i3) {
//        if (ans) return;
//        if (i1 == s1.length()) {
//            sb.append(s2.substring(i2));
//            i2 = s2.length();
//        }
//        if (i2 == s2.length()) {
//            sb.append(s1.substring(i1));
//            i1 = s1.length();
//        }
//        if (i1 == s1.length()) {
//            if (sb.toString().equals(s3)) {
//                ans = true;
//            }
//            return;
//        }
////        if (visited[i1][i2])  return;
//        visited[i1][i2] = true;
//        if (s1.charAt(i1) == s3.charAt(i3)) {
//            sb.append(s1.charAt(i1));
//            dfs(i1 + 1, i2, i3 + 1);
//        }
//        sb.delete(i3, sb.length());
//        if (s2.charAt(i2) == s3.charAt(i3)) {
//            sb.append(s2.charAt(i2));
//            dfs(i1, i2 + 1, i3 + 1);
//        }
//    }
}
