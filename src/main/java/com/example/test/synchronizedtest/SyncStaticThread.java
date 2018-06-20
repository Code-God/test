package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 14:49
 * I am a Code Man -_-!
 */
public class SyncStaticThread implements Runnable {

    private static int count;

    public SyncStaticThread() {
        count = 0;
    }

    public synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }

    /**
     * syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。
     * 这是因为run中调用了静态方法method，而静态方法是属于类的，所以syncThread1和syncThread2相当于用了同一把锁。
     *
     * @param args
     */
    public static void main(String args[]) {
        SyncStaticThread syncThread1 = new SyncStaticThread();
        SyncStaticThread syncThread2 = new SyncStaticThread();
        Thread thread1 = new Thread(syncThread1, "线程1");
        Thread thread2 = new Thread(syncThread2, "线程2");
        thread1.start();
        thread2.start();
    }

    //给class加锁和上例的给静态方法加锁是一样的，所有对象公用一把锁

    /**
     * 同步线程
     */
//    class SyncThread implements Runnable {
//        private static int count;
//
//        public SyncThread() {
//            count = 0;
//        }
//
//        public static void method() {
//            synchronized (SyncThread.class) {
//                for (int i = 0; i < 5; i++) {
//                    try {
//                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

//        public synchronized void run() {
//            method();
//        }
//    }

}