package com.example.test.synchronizedtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 16:08
 * I am a Code Man -_-!
 */
public class Temp {
    int count = 0;

    //this对象锁

    public void waiter() throws InterruptedException {
        synchronized (this) {
            System.out.println("等待");
            wait();
            System.out.println(this.count);
        }
    }

    public void notifyer() throws InterruptedException {
        synchronized (this) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("唤醒");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + " >>notifyer:" + i);
                count += i;
            }
            notify();
        }
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Waiter(temp));
        executorService.execute(new Notifyer(temp));
        executorService.shutdown();
    }
}
