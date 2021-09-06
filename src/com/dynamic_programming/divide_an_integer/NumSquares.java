package com.dynamic_programming.divide_an_integer;

import java.util.*;

// 279. 完全平方数
public class NumSquares {
    public static void main(String[] args) {
//        List<Integer> integers = generateSquares(25);
//        System.out.println(integers);
        int i = numSquares(12);
        System.out.println(i);
        List list = new ArrayList();
        list.iterator();
    }

    //2. dp
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        List<Integer> squares = generateSquares(n);
        for (int i = 1; i <= n; i++) {
            for (Integer square : squares) {
                if (square > i) break;
                dp[i] = Math.min(dp[i - square] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    private static List<Integer> generateSquares(int n) {
        int square = 1;
        int sub = 3;
        LinkedList<Integer> list = new LinkedList<>();
        while (square <= n) {
            list.add(square);
            square += sub;
            sub += 2;
        }
        return list;
    }
}
