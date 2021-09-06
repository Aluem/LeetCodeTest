package com.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//按照字符出现次数对字符串排序
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        String ans = sortCharactersByFrequency.frequencySort(s);
        System.out.println(ans);
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> charsNum = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {  // O(n * ...)
            charsNum.put(c, charsNum.getOrDefault(c, 0) + 1); //里面有数组、链表、红黑树的操作
        }
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : charsNum.keySet()) { // O(n)
            int count = charsNum.get(c);
            if (frequencyBucket[count] == null) {
                frequencyBucket[count] = new ArrayList<>();
            }
            frequencyBucket[count].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) { // O(n)
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
