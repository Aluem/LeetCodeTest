package com.bs;

import java.util.Arrays;
import java.util.Comparator;

public class TruckGo {

    public boolean truckGo (int[][] load, int capacity) {
        // write code here
        Arrays.sort(load, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < load[load.length - 1][1]; i++) { //0 到 最后一个 载货点
            for (int j = 0; j < load.length; j++) {
                //先卸货
                if (i == load[j][2]) {
                    capacity += load[j][0];
                }
                if (i == load[j][1]) { // 需要载物
                    capacity -= load[j][0];
                }
                if (capacity < 0) {
                    return false;
                }
            }
        }
        return true;
    }

//    private int getLeastStart(int[][] load)  {
//
//
//
//    }
}
