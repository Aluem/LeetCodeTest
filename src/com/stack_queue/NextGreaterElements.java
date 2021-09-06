package com.stack_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//503. 下一个更大元素 II
public class NextGreaterElements {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int index = stack.pop();
                next[index] = nums[i % n];
            }
            stack.push(i % n);
        }
        return next;
    }
}
