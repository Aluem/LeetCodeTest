package com.greedy;

//121. 买卖股票的最佳时机
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin) {
                maxProfit = Math.max(prices[i] - curMin, maxProfit);
            } else {
                curMin = prices[i];
            }
        }
        return maxProfit;
    }
}
