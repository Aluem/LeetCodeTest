package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

//452. 用最少数量的箭引爆气球
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[1] < intervals2[1] ? -1 : ((intervals1[1] == intervals2[1]) ? 0 : 1);
            }
        });

        int count = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }
}
