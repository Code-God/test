package com.example.test.test1;


import java.io.PrintStream;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/19
 * @Time: 18:08
 * I am a Code Man -_-!
 */
public class Test3 {

    public static void main(String[] args){
        int a = 1;
        int b = 2;
        display(a,b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        //a=10
        //b=20
    }

    public static void display(int a, int b){
//        a = 10;
//        b = 20;
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//        System.exit(0); //让虚拟机退出

        PrintStream ps = new PrintStream(System.out) {
            @Override
            public void println(String x){
                if(x!=null) {
                    if(x.startsWith("a")) {
                        super.println("a=20");
                    }else if(x.startsWith("b")) {
                        super.println("b=20");
                    }
                }else {
                    throw new NullPointerException();
                }
            }
        };
    }

}
