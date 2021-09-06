package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

//435. 无重叠区间
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        String s0 = "good";

        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);


        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
//        System.out.println(s2.intern() == s2);

//        String s3 = new StringBuilder("go")
//                .append("od").toString();
//        System.out.println(s3.intern() == s3);
//
//        String s3 = "123";
//        String s4 = new String("123");
//
//        System.out.println(s3 == s4);
//
//        String s5 = s4.intern();
//        System.out.println(s3 == s5);


    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[1] - intervals2[1];
            }
        });

        int count = 1;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
