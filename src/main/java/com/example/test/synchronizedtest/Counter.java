package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 14:31
 * I am a Code Man -_-!
 */
public class Counter implements Runnable{

    /**
     * 当一个线程访问对象的一个synchronized(this)同步代码块时，
     * 另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。
     */


    private int count;

    public Counter() {
        count = 0;
    }

    public void countAdd() {
        synchronized(this) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "对count加1  => " + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("线程1")) {
            countAdd();
        } else if (threadName.equals("线程2")) {
            printCount();
        }
    }

    public static void main(String args[]){
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter, "线程1");
        Thread thread2 = new Thread(counter, "线程2");
        thread1.start();
        thread2.start();
    }
}
