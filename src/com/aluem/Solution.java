package com.aluem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String s = "abpcplea";
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        Solution solution = new Solution();
        String longestWord = solution.findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }

    public String findLongestWord(String s, List<String> dictionary) {
        //size : 当前满足的最长的字符串
        int i = 0, j =0, size = 0;
        String res = "";
        char[] cs = s.toCharArray();
        for (String str : dictionary) {
            char[] cstr = str.toCharArray();
            while (i < cs.length) {
                if (cs[i] == cstr[j]) {
                    j++;
                }
                if (j >= cstr.length) {
                    break;
                }
                i++;
            }

            if (j == str.length() && j >= size) {
                if (j > size) {
                    res = str;
                }
                if (j == size) {
                    res = getMinStr(res, str);
                }
                size = j;
            }
            i = 0;
            j = 0;
        }
        return res;
    }

    /**
     * 返回字典顺序最小的字符串 s1和s2长度一致
     * @return
     */
    public String getMinStr(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if (chars1[i] < chars2[i]) {
                return s1;
            } else if (chars1[i] > chars2[i]) {
                return s2;
            }
        }
        return s1;
    }
}