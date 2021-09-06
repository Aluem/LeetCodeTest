package com.one_quest_per_day;

import java.util.Arrays;

//443. 压缩字符串
public class Compress_21_08_21 {
    public static void main(String[] args) {
        Compress_21_08_21 compress_21_08_21 = new Compress_21_08_21();
//        int compress = compress_21_08_21.compress(new char[]{'a','a'});
        int compress = compress_21_08_21.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println(compress);
    }

    public int compress(char[] chars) {
        int l = chars.length;
        if (l == 1) return 1;
        int left = 0, write = 0;
        for (int read = 0; read < l; read++) {
            if (read == l - 1 || chars[read] != chars[read + 1]) {
                int num = read - left + 1;
                chars[write++] = chars[read];
                int anchor = write;
                if (num > 1) {
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                }
                reverse(chars, anchor, write - 1);
                left = read + 1;
            }
        }
        System.out.println(Arrays.toString(chars));
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

//    public int compress(char[] chars) {
//        int len = chars.length;
//        if (len == 1) return 1;
//        int f = 0, write = 0; // f 指向一个组的队头, write 写指针
//        for (int read = 1; read < len; read++) {
//            if (chars[read] == chars[f] && read != len - 1) { // 相同且不是最后一位读指针后移
//                continue;
//            }
//            // read指向的元素不等于组头元素 或者 读指针到达最后一个元素
////            System.out.println(chars[f]);
////            System.out.println(Arrays.toString(chars));
//            chars[write++] = chars[f]; // 写指针位置添加组头元素, 写指针后移
//            char pre = chars[read - 1]; //保留前一个元素
//            char cur = chars[read]; //保留当前元素
//
//            int num = read - f; // 当前组的长度
//            if (read == len - 1 && chars[read] == chars[read - 1]) { // 读指针到达最后一个元素且等于前一个元素
//                num++;
//            }
//            if (num > 1) { // 当前组长度大于 1, 才记录长度
//                int l = (num + "").length();
//                int left = write; // 长度的写指针头
//                while (num > 0) {
//                    chars[write++] = (char) (num % 10 + '0'); // 记录长度, 写指针后移
//                    num /= 10;
////                    if (num == 0) write--;
//                }
//                // 长度反转
//                reverse(chars, left, left + l - 1);
//            }
//            f = read; // 组头元素更换
//            if (read == len - 1 && cur != pre) { // 读指针到达最后一个元素且不等于前一个元素
//                // 直接加入写数组
//                chars[write++] = chars[read];
//                break;
//            }
//        }
//        return write;
//    }


//    for (int j = 1, k = 1; j <= len; j++, k *= 10) {
//                    tmp = cnt / k % 10;
//                    chars[idx + cntStr.length() - j] = (char) (tmp + 48);
//                }
}
