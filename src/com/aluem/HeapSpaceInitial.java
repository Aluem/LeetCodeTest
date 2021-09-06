package com.aluem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HeapSpaceInitial {
//    static final int MAX_COUNT = 1000 * 10000;
//    static final String[] arr = new String[MAX_COUNT];
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String.valueOf(i).intern();
        }
        System.out.println(1);
        //============================================================

//        Integer [] data = new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < MAX_COUNT; i++) {
//            arr[i] = new String(String.valueOf(data[i%data.length])).intern();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("花费的时间为：" + (end - start));
//
//        try {
//            Thread.sleep(1000000);
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
        //============================================================

//        //字符串常量表没有"11" s3 = new String("11")
//        String s3 = new String("1") + new String("1");
//        String s2 = s3;
//
//        s3.intern(); //jdk11不是指向new String的地址 而是在常量池创建 "11"
//        String s4 = "11";
//        System.out.println(s3 == s4); // false open jdk11
////        String s1 = "11";
////        System.out.println(s4 == s1); //true 常量池
////        System.out.println(s2 == s3); //true s3仍然是new String的地址



        //============================================================

//        String str = new String("ab");
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2); // true
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4); // true
        //============================================================

        //测试类中的字符串是否存放在常量池
//        Student student = new Student();
//        student.name = "zhangsan";
//
//        String name = "zhangsan";
//
//        System.out.println(name == student.name); //true


        //============================================================

//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
//        System.out.println("4");
//        System.out.println("5");
//        System.out.println("6");
//        System.out.println("7");
//        System.out.println("8");
//        System.out.println("9");
//        System.out.println("10");//3230
//
//        System.out.println("1");//3231
//        System.out.println("2");
//        System.out.println("3");
//        System.out.println("4");
//        System.out.println("5");//3231
//        System.out.println("6");
//        System.out.println("7");
//        System.out.println("8");
//        System.out.println("9");
//        System.out.println("10");
        //============================================================
//        String a = "abc";
//        String b = new String("abc");
//        System.out.println(a == b);
        //============================================================

//        int i = 0;
//        LinkedList<Object> list = new LinkedList<>();
//        while (true) {
//            list.add("hhhh");
//            try {
//                Thread.sleep(1000000000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}

class Student {
    String name;
}