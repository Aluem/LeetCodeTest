package com.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        Map<Character, Integer> sMap = getCharCount(s);
//        Map<Character, Integer> tMap = getCharCount(t);
//        Set<Character> sKey = sMap.keySet();
//        for (Character c : sKey) {
//            if (!tMap.containsKey(c)) return false;
//            if (!sMap.get(c).equals(tMap.get(c))) return false;
//        }
//        return true;
//    }
//
//    private static Map<Character, Integer> getCharCount(String s) {
//        char[] ch = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < ch.length; i++) {
//            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
//        }
//        return map;
//    }
}
