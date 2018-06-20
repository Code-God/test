package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 14:25
 * I am a Code Man -_-!
 */
public class SyncThread implements Runnable {

    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(">>"+Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }


    public static void main(String args[]){
        //test01
        SyncThread s1 = new SyncThread();
        SyncThread s2 = new SyncThread();
        Thread t1 = new Thread(s1,"线程1");
        Thread t2 = new Thread(s2,"线程2");

        //test02
        /**
         * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
         * 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。
         * Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，
         * 只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象
         */
//        SyncThread s = new SyncThread();
//        Thread t1 = new Thread(s);
//        Thread t2 = new Thread(s);

        t1.start();
        t2.start();
    }
}
