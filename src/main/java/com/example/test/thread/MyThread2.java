package com.example.test.thread;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 11:28
 * I am a Code Man -_-!
 */
public class MyThread2 extends Thread{

    private String name;

    public MyThread2(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }

   // 如果直接调用run方法，即相当于在主线程中执行run方法，跟普通的方法调用没有任何区别，此时并不会创建一个新的线程来执行定义的任务。


    public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        MyThread2 thread1 = new MyThread2("thread1");
        thread1.start();
        MyThread2 thread2 = new MyThread2("thread2");
        thread2.run();
    }
}
