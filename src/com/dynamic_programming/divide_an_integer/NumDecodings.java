package com.dynamic_programming.divide_an_integer;

//91. 解码方法
public class NumDecodings {

    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < len + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len + 1];
    }



    // =============================================
//    public int numDecodings(String s) {
//        if (s.charAt(0) == '0') return 0;
//        int len = s.length();
//        int[] dp = new int[len + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for (int i = 2; i <= len; i++) {
//            int one = Integer.parseInt(s.substring(i - 1, i));
//            if (one != 0) {
//                dp[i] += dp[i - 1];
//            }
//            if (s.charAt(i - 2) == '0') {
//                continue;
//            }
//            int two = Integer.parseInt(s.substring(i - 2, i));
//            if (two <= 26) {
//                dp[i] += dp[i - 2];
//            }
//        }
//        return dp[len];
//    }
}
