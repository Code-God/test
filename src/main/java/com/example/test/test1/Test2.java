package com.example.test.test1;

import java.util.Scanner;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/19
 * @Time: 16:40
 * I am a Code Man -_-!
 */
public class Test2 {
    /**
     * 一对兔子，从出生后第3个月起每个月都生一对兔子。小兔子长到第3个月后每个月又生一对兔子
     * @param args
     */
    public static void main(String[] args) {
//        for(int i=1;i<=10;i++) {
//            long n = fib(i);
//            //算出的是对数.要算总数的法,*2就行
//            System.out.println("第" + i + "个月有兔子对数为" + n);
//        }
        long s1 = 1;
        long s2 = 1;
        int count;
        long temp;
        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            if (i == 1) {
                System.out.println("第" + i + "个月的兔子对数：" + s1);
                continue;
            } else if (i == 2) {
                System.out.println("第" + i + "个月的兔子对数：" + s2);
                continue;
            } else {
                temp = s2;
                s2 = s1 + s2;
                s1 = temp;
                System.out.println("第" + i + "个月的兔子对数：" + s2);
            }
        }
    }

    //斐波那契数列
    static long fib(int x){
        if(x>2) {
            return (fib(x-1)+fib(x-2));
        } else {
            return 1;
        }
    }
}
