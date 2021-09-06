package com.dynamic_programming;

import java.util.*;
class Main{
    public static void main(String args[]){
        int m;
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            m = sc.nextInt();
            int ans = 0;
            while (m > 1) {
                m = m / 2;
                if (m % 2 == 1) ans++;
            }
            if (m == 1) ans++;
            System.out.println(ans);
        }
    }
}