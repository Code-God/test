package com.example.test.ab;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 10:07
 * I am a Code Man -_-!
 */
public class B {

    public B() {
        System.out.println("父类-构造方法");
    }

    static {
        System.out.println("父类-静态块");
    }

    {
        System.out.println("父类-非静态块");
    }

    public static void staticFunc() {
        System.out.println("父类-静态方法");
    }

    public void func() {
        System.out.println("父类-普通方法");
    }

    public static void main(String[] args) {
        B.staticFunc();
    }
}
