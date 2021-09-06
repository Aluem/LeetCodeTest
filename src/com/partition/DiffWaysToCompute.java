package com.partition;

import java.util.ArrayList;
import java.util.List;

//241. 为运算表达式设计优先级
public class DiffWaysToCompute {
    public static void main(String[] args) {
        String str = "2*3-4*5+7";
//        String[] split = str.split("[+,*,-]");
//        for (String s : split) {
//            System.out.println(s);
//        }
        str.substring(2);

        String exps = "2-1-1";
        System.out.println(diffWaysToCompute(exps));
    }

    //分治
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '*' || c == '-' || c == '+') {
                //将算数运算符左右两边分治
                List<Integer> listL = diffWaysToCompute(expression.substring(0, i));
                List<Integer> listR = diffWaysToCompute(expression.substring(i + 1));
                //左边的所有结果与右边所有结果结合
                for (int j = 0; j < listL.size(); j++) {
                    for (int k = 0; k < listR.size(); k++) {
                        if (c == '*') {
                            list.add(listL.get(j) * listR.get(k));
                        } else if (c == '-') {
                            list.add(listL.get(j) - listR.get(k));
                        } else {
                            list.add(listL.get(j) + listR.get(k));
                        }
                    }
                }
            }
        }
        //只剩数字时放入list中
        if (list.size() == 0) {
            list.add(Integer.parseInt(expression));
        }
        return list;
    }
}
