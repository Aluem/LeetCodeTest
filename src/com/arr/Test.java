package com.arr;

import java.util.*;

public class Test {



    //============================================

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String arr = in.nextLine();
//        String[] s = arr.split(" ");
//        int[] arrNum = new int[s.length];
//        for (int i = 0; i < s.length; i++) {
//            arrNum[i] = Integer.parseInt(s[i]);
//        }
//        System.out.println(Arrays.toString(arrNum));
//        System.out.println(maxSum(arrNum));
//    }
//
//    public static int maxSum(int[] arr) {
//        int ans = arr[0];
//        int num = 0;
//        for (int i = 0; i < arr.length; i++) {
//            num += arr[i];
//            ans = Math.max(ans, num);
//            if (num < 0) {
//                num = 0;
//            }
//        }
//        return ans;
//    }

    //======================================
//    public static void main(String[] args) {
////        String s = "123*45";
////
////        String str = "123aaaaaa45";
////        System.out.println(get(s, str));
////        int i = s.indexOf("*");
////        String substring = s.substring(0, i);
////        System.out.println(substring);
//        //shopee*.com     shopeemobile.com
//        Scanner in = new Scanner(System.in);
//        String s = in.next();//数组长度
//        String str = in.next();//阈值k
//        System.out.println(get(s, str));
//    }
//
//    //s : 含通配符字符串
//    public static String get(String s, String str) {
//        int l = 0;//左边已经截取的字符串
//        int r = 0;//右边已经截取的字符串
//        StringBuilder ans = new StringBuilder();
//        int i = s.indexOf("*");
//        String subHead = s.substring(0, i);
//        String subTail = s.substring(i + 1);
//        while (true) {
//            int subHeadIndex = str.indexOf(subHead);
//            int subTailIndex = str.indexOf(subTail);
//            if (subHeadIndex < 0 || subTailIndex < 0) return ans.toString();
//            String pivotString = str.substring(subHeadIndex + subHead.length(), subTailIndex);
//                ans.append((subHeadIndex + l) + " " + (subTailIndex - r - subHeadIndex - l + subTail.length()) + "\n");
//                l += subHeadIndex;
//                r += subTailIndex;
//                str = pivotString;
//        }
//    }
    //========================================================

//    public static void getAll(String str) {
//        for (int i = 0; i < str.length(); i++) {
//
//        }
//    }
//
//    public static void rec(char[] chars, int l) {
//
//    }


    //========================================================

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();//数组长度
//        int k = in.nextInt();//阈值k
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        System.out.println(getNum(arr, k));
//    }
//
//    //求超过阈值的数组元素
//    public static int getNum(int[] arr, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int ans = -1;
//        for (int i = 0; i < arr.length; i++) {
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//        Set<Integer> integers = map.keySet();
//        for (Integer num : integers) {
//            if (map.get(num) > k && map.get(num) > ans) {
//                ans = num;
//            }
//        }
//        return ans;
//    }

    //========================================================
//    //链表翻转
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        List list = new ArrayList();
//        String s = scanner.nextLine();
//        String[] strs = s.split(" ");
//        System.out.println(Arrays.toString(strs));
//        for (int i = 0; i < strs.length; i++) {
//            list.add(strs[i]);
//        }
//        List reverse = reverse(list, k);
//        for (Object o : reverse) {
//            System.out.print(o + " ");
//        }
//    }
//
//    public static List reverse(List list, int k) {
//        List<Integer> ans = new LinkedList();
//        for (int i = 0; i < list.size(); i += k) {
//            List tmp = null;
//            if (i + k < list.size()) {
//                tmp = list.subList(i, i + k);
//            } else {
//                tmp = list.subList(i, list.size());
//            }
//            Collections.reverse(tmp);
//            ans.addAll(tmp);
//        }
//        return ans;
//    }

//========================================================
    //    //斐波那契数列
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(fei(n));
//    }
//
//    public static int fei(int k) {
//        if (k == 1 || k == 2) {
//            return 1;
//        }
//        int pre = 1;
//        int ans = 1;
//        if (k == 4) return 3;
//        for (int i = 0; i < k - 2; i++) {
//            ans = pre + ans;
//            pre = ans;
//        }
//        return ans;
//    }
//
////    public static int fei(int k) {
////        if (k == 1 || k == 2) {
////            return 1;
////        }
////        return fei(k - 1) + fei(k - 2);
////    }
}

abstract class AbstractBeanFactory {

    private Object obj = null;

    public abstract Object getBean();

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

class ConcreteFactory extends AbstractBeanFactory {

    @Override
    public Product getBean() {
        if (getObj() == null) {
            setObj(new ConcreteProduct());
        }
        return (Product) getObj();
    }
}

abstract class Product {
    private String name;

    public abstract void show();
}

class ConcreteProduct extends Product {

    @Override
    public void show() {
        System.out.println("产品销售");
    }
}