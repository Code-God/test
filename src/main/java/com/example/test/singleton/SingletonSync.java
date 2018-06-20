package com.example.test.singleton;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 10:43
 * I am a Code Man -_-!
 */
public class SingletonSync {

    private SingletonSync() {

    }

    private static SingletonSync single = null;

    //但是以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，
    // 并发环境下很可能出现多个Singleton实例，要实现线程安全，有以下三种方式，
    // 都是对getInstance这个方法改造，保证了懒汉式单例的线程安全

    //1 在getInstance方法上加同步
    public static synchronized SingletonSync getInstance1() {
        if(single == null) {
            single = new SingletonSync();
        }
        return single;
    }

    //2 双重检查锁定
    public static SingletonSync getInstance2() {
        if(single == null) {
            synchronized (SingletonSync.class) {
                if(single == null) {
                    single = new SingletonSync();
                }
            }
        }
        return single;
    }

    //3 静态内部类   这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响。
    private static class LazyHolder {
        private static final SingletonSync INSTANCE = new SingletonSync();
    }
    public static final SingletonSync getInstance() {
        return LazyHolder.INSTANCE;
    }
}
