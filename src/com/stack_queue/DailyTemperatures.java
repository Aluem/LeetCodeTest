package com.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//739. 每日温度
/*
    temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
                    [1, 1, 4, 2, 1, 1, 0, 0]
 */
public class DailyTemperatures {

    //2.单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //添加的值大于栈顶的值
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    //================================================
    //1.暴力法
    /*
        时间复杂度 O(n^2) 最坏情况 降序排列
        空间复杂度 O(n)
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            for (int j = i + 1; j < temperatures.length; j++) {
//                if (temperatures[j] > temperatures[i]) {
//                    res[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }
}
