package com.stack_queue;

import java.util.ArrayList;
import java.util.List;

//155. 最小栈
public class MinStack {

    List<Integer> list;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val < min) min = val;
        list.add(val);
    }

    public void pop() {
        list.remove(list.size() - 1);
        setMin();
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public void setMin() {
        int curMin = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (i < curMin) {
                curMin = i;
            }
        }
        min = curMin;
    }

}
