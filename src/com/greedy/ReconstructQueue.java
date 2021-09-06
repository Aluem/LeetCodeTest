package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.toString(reconstructQueue(people)));
    }

    //先把大的放前面，则后面的都是小于等于已经放的，插入相应位置
    //一样大的先放ki位置小的，不会影响到ki位置大的，若先放ki大的，当把ki小的插入到前面时会影响到ki大的
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);
    }
}
