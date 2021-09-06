package com.dynamic_programming.divide_an_integer;

import java.util.Arrays;

//343. Integer Break (Medim)
public class IntegerBreak {
//    // dp[i] 表示 整数 i 的整数拆分乘积最大值
//    private int[] dp = new int[59];
//    public int integerBreak(int n) {
//        dp[1] = dp[2] = 1;
//        int sub = 0, ans = 0;
//        if (dp[n] == 0) {
//            setDp(n);
//        }
//        return dp[n];
//    }
//
//    private void setDp(int n) {
//        if (dp[n] == 0) {
//            int sub = 0, ans = 0;
//            for (int i = 3; i < dp.length; i++) {
//                if (dp[i] == 0) {
//                    for (int j = i; j <= n; j++) {
//                        sub = j / 2;
//                        for (int k = 0; k <= sub; k++) {
//                            int tmp = Math.max(dp[k], k) * Math.max(dp[j - k], j - k);
//                            if (tmp > ans) {
//                                ans = tmp;
//                            }
//                        }
//                        dp[j] = ans;
//                    }
//                    break;
//                }
//            }
//        }
//    }




    class Solution {
        // dp[i] 表示 整数 i 的整数拆分乘积最大值
        private int[] dp = new int[59];
        public int integerBreak(int n) {
            dp[1] = dp[2] = 1;
            int sub = 0, ans = 0;
            if (dp[58] == 0) {
                for (int i = 3; i <= n; i++) {
                    sub = i / 2;
                    for (int j = 0; j <= sub; j++) {
                        int tmp = Math.max(dp[j], j) * Math.max(dp[i - j], i - j);
                        if (tmp > ans) {
                            ans = tmp;
                        }
                    }
                    dp[i] = ans;
                }
            }
            return dp[n];
        }
    }



//    // dp[i] 表示 整数 i 的整数拆分乘积最大值
//    private int[] dp = new int[59];
//    public int integerBreak(int n) {
//        dp[1] = dp[2] = 1;
//        int sub = 0, ans = 0;
//        if (dp[58] == 0) {
//            for (int i = 3; i <= 58; i++) {
//                sub = i / 2;
//                for (int j = 0; j <= sub; j++) {
//                    int tmp = Math.max(dp[j], j) * Math.max(dp[i - j], i - j);
//                    if (tmp > ans) {
//                        ans = tmp;
//                    }
//                }
//                dp[i] = ans;
//            }
//        }
//        return dp[n];
//    }
}
