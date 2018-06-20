package com.example.test.thread;

/**
 * @Author: wuxiaobiao
 * @Description: 实现Runnable接口必须重写其run方法。
 * @Date: Created in 2018/6/20
 * @Time: 11:31
 * I am a Code Man -_-!
 */
public class MyRunnable implements Runnable {

    public MyRunnable() {
    }

    @Override
    public void run() {
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
