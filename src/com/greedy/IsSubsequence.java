package com.greedy;

//392. 判断子序列
public class IsSubsequence {

      public boolean isSubsequence(String s, String t) {
         int n = s.length(), m = t.length();
         int i = 0, j = 0;
         while (i < n && j < m) {
             if (s.charAt(i) == t.charAt(j)) {
                 i++;
             }
             j++;
         }
         return i == n;
     }


//    public boolean isSubsequence(String s, String t) {
//        int cnt = 0;
//        int prev = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = prev; j < t.length(); j++) {
//                if (s.charAt(i) == t.charAt(j)) {
//                    cnt++;
//                    prev = ++j;
//                    if (cnt == s.length()) return true;
//                    break;
//                }
//            }
//        }
//        return cnt == s.length();
//    }
}
