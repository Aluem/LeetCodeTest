package com.aluem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day05 {


    public static void main(String[] args) {
        day05 day05 = new day05();
        List<String> strings = day05.letterCombinations("");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ArrayList<String> list = new ArrayList<>();
        dfs(0, list, map, "", digits);
        return list;
    }

    /**
     * 深度优先选择字母组合
     * @param num 选择到了第几个字母，与digits的长度一致时表示已经选择完毕
     * @param res 结果集合
     * @param map 数字与字母对应的map
     * @param s 已经组合的字符串
     * @param digits 输入的数字
     */
    public void dfs(int num, List res, Map<Integer, String> map, String s, String digits) {
        if (num == digits.length()) { //已经从所有数字对应的字母中挑选了足够的字符进行组合
            res.add(s);
            return;
        }
        //从第一个数字中选择字母
        String c = digits.charAt(num) + ""; //2
        int i = Integer.parseInt(c); //2
        String s1 = map.get(i); // abc

        for (int j = 0; j < s1.length(); j++) {
            dfs(num + 1, res, map, s + s1.charAt(j), digits);
        }
    }

}
