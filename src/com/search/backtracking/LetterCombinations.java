package com.search.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//17. 电话号码的字母组合
public class LetterCombinations {
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return null;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtracking(digits, 0, new StringBuilder(), map);
        return res;
    }

    public void backtracking(String dig, int i, StringBuilder sb, Map<Character, String> map) {
        if (i >= dig.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map.get(dig.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
            backtracking(dig, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
