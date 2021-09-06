package com.bs;


import java.util.*;

public class Main {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int i = in.nextInt();
//        String e = in.nextLine();
//        String next = in.nextLine();
//        String[] split = next.split(" ");
//        int[] p = new int[split.length];
//        for (int j = 0; j < p.length; j++) {
//            p[j] = Integer.parseInt(split[j]);
//        }
//
//        int size = 0;
//        for (int j = 1; j < p.length - 1; j++) {
//            if (p[j - 1] > p[j] && p[j + 1] < p[j]) {
//                size++;
//            } else if (p[j - 1] < p[j] && p[j + 1] > p[j]) {
//                size++;
//            }
//        }
//        System.out.println(size);
//    }


    private static Set<String> set = new HashSet<>();// 记忆化搜索
    private static Set<String> ans = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        dfs(0, new StringBuilder(), s);
        System.out.println(ans.size());
    }

    /**
     * 回溯
     * @param start
     * @param sb
     * @param s
     */
    private static void dfs(int start, StringBuilder sb, String s) {
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!ans.contains(sb.toString())) {
                if (sb.length() % 2 == 1 && isHuiWen(sb.toString())) {
                    ans.add(sb.toString());
                }
            }
            dfs(i + 1, sb, s);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 判断是否为回文串
     * @param s
     * @return
     */
    private static boolean isHuiWen(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
            if (set.contains(s.substring(l, r + 1))) ;
        }
        return true;
    }
}