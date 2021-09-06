package com.aluem;

public class day07 {
    public static void main(String[] args) {
        day07 day07 = new day07();
        for (int i = 0; i < 5; i++) {
            boolean b = day07.judgeSquareSum(i);
            System.out.println(b);
        }
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c) + 1;
        boolean flag = false;

        while (left <= right) {
            if ((left * left + right * right) > c) {
                right--;
            } else if ((left * left + right * right)< c) {
                left++;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
