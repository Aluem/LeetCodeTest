package com.aluem;

import java.util.ArrayList;
import java.util.List;

public class day03 {
    public static void main(String[] args) {
        day03 day03 = new day03();
        List<String> strings = day03.generateParenthesis(2);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        dfs(n , n, list, "");
        return list;
    }


    /**
     * @param left  左括号还有多少个没有用掉
     * @param right 右括号还有多少个没有用掉
     * @param list  保存结果的数组
     * @param s     当前括号组成的字符串
     */
    public void dfs(int left, int right, List<String> list, String s) {
        if (left == 0 && right == 0) { //左括号和右括号都用完了
            list.add(s);
            return;
        }
        //剪枝
        if (left > right) {
            return;
        }
        if (left > 0) {
            //添加左括号
            dfs(left - 1, right, list, s + "(");
        }
        if (right > 0) {
            //添加右括号
            dfs(left, right - 1, list, s + ")");
        }
    }
}

