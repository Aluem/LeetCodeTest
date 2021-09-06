package com.dynamic_programming.matrix_path;

//62. 不同路径
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j]; // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1]; // 只能从左侧走到该位置
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
