package com.bs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CanMeasureWater {
    public static void main(String[] args) {
        new CanMeasureWater().canMeasureWater(3, 13, 5);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cup1Capacity   int整型 水杯1容量
     * @param cup2Capacity   int整型 水杯2容量
     * @param targetCapacity int整型 目标容量
     * @return bool布尔型
     */
    public boolean canMeasureWater(int cup1Capacity, int cup2Capacity, int targetCapacity) {
        if (cup1Capacity == cup2Capacity) {
            if (cup1Capacity == targetCapacity) {
                return true;
            } else {
                return false;
            }
        }
        // write code here
        List<Integer> waters = getWaters(cup1Capacity, cup2Capacity);
        boolean[] dp = new boolean[targetCapacity + 1];
        dp[0] = true;
        for (Integer water : waters) {
            if (water <= targetCapacity)
                dp[water] = true;
        }
        for (int i = 1; i <= targetCapacity; i++) {
            System.out.println("i -- >" + i);
            for (int j = 1; j < i; j++) {
                if (dp[i - j] && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(waters);
        return dp[targetCapacity];
    }

    private List<Integer> getWaters(int c1, int c2) {
        List<Integer> waters = new LinkedList<>();
        int min = Math.min(c1, c2);
        int max = Math.max(c1, c2);
        int tmpMin = min;
        int tmpMax = max;
        while (tmpMin <= max) {
            waters.add(tmpMin); // 用小杯量
            tmpMin += min;
        }
        waters.add(tmpMin - max); // 多个小杯比大杯多时, 取最后的小杯剩余量
        while (tmpMax > 0) {
            waters.add(tmpMax); // 用大杯量
            tmpMax -= min;
        }
        return waters;
    }
}
