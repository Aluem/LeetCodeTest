package com.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//763. 划分字母区间
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new LinkedList<>();
        int strFir = 0, strLast = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';//字母在数组中的下标
            if (i > strLast) {
                list.add(i - strFir);
                strFir = i;
            }
            strLast = Math.max(strLast, last[idx]);
        }
        if (strLast >= strFir) {
            list.add(strLast - strFir + 1);
        }
        return list;
    }
}
