package com.greedy;

//122. 买卖股票的最佳时机 II
public class MaxProfit2 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }


    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    /*
        思路：
           买入目前最小的，找到连续递增的最后一个抛售
           将连续递增的最后一个当作下一次目前最小的
     */
//    public static int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) return 0;
//        int curMin = prices[0];
//        int maxProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            while (prices[i] > curMin && i + 1 < prices.length && prices[i + 1] > prices[i]) {
//                i++;
//            }
//            if (prices[i] > curMin) {
//                maxProfit += prices[i] - curMin;
//            }
//            curMin = prices[i];
//        }
//        return maxProfit;
//    }
}
