package com.string;

import java.util.HashMap;
import java.util.Map;

//205. 同构字符串
public class IsIsomorphic {
    public static void main(String[] args) {
        new IsIsomorphic().isIsomorphic("eag", "add");
    }
    /*
        解题思路：
            记录一个count 遍历字符串 若当前字符在该字符串出现过，则获取其数字 若没出现过 count代表该字符 count++
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        String numS = getNumString(s);
        String numT = getNumString(t);
        System.out.println(numS);
        System.out.println(numT);
        return numS.equals(numT);
    }

    private String getNumString(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                sb.append(map.get(str.charAt(i)));
            } else {
                map.put(str.charAt(i), count);
                sb.append(count++);
            }
        }
        return sb.toString();
    }
}
