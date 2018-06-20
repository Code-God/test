package com.example.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wuxiaobiao
 * @Description: 公平锁
 * @Date: Created in 2018/6/20
 * @Time: 13:49
 * I am a Code Man -_-!
 */
public class LockTest {

    // Lock实现和synchronized不一样，后者是一种悲观锁，它胆子很小，它很怕有人和它抢吃的，所以它每次吃东西前都把自己关起来。
    // 而Lock呢底层其实是CAS乐观锁的体现，它无所谓，别人抢了它吃的，它重新去拿吃的就好啦，所以它很乐观
    // lock可以让等待的线程不用一直等待下去

    //Lock和synchronized有一点非常大的不同，采用synchronized不需要用户去手动释放锁，
    // 当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；
    // 而Lock则必须要用户去手动释放锁，如果没有主动释放锁，就有可能导致出现死锁现象。
    //在并发量比较小的情况下，使用synchronized是个不错的选择，但是在并发量比较高的情况下，其性能下降很严重，此时ReentrantLock是个不错的方案。

    private Lock lock = new ReentrantLock();

    //需要参与同步的方法
    private void method(Thread thread){

//        // lock
//        lock.lock();
//        try {
//            System.out.println("线程名"+thread.getName() + "获得了锁");
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally {
//            System.out.println("线程名"+thread.getName() + "释放了锁");
//            lock.unlock();
//        }

        // tryLock():
        if(lock.tryLock()){
            try {
                System.out.println("线程名"+thread.getName() + "获得了锁");
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                System.out.println("线程名"+thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else{
            System.out.println("我是"+Thread.currentThread().getName()+"有人占着锁，我就不要啦");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        //线程1
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
