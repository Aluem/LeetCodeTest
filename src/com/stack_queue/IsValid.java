package com.stack_queue;

import java.util.*;

public class IsValid {

    public static void main(String[] args) {
        String str = "()";
        System.out.println(new IsValid().isValid(str));
    }


//    public boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
//            put(')', '(');
//            put(']', '[');
//            put('}', '{');
//        }};
//        Deque<Character> stack = new LinkedList<Character>();
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i); //ch = ')' || ']' || '}' 则匹配
//            if (pairs.containsKey(ch)) {
//                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(ch); // stack : '('
//            }
//        }
//        return stack.isEmpty();
//    }

    //=================================================
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2== 1) return false;
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (pairs.containsKey(ch[i])) { //右括号
                if (stack.isEmpty() || pairs.get(ch[i]) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                //左括号
                stack.push(ch[i]);
            }
        }
        return stack.isEmpty();
    }
}
