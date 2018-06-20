package com.example.test.thread;

/**
 * @Author: wuxiaobiao
 * @Description: 继承Thread类，必须重写run方法
 * @Date: Created in 2018/6/20
 * @Time: 11:24
 * I am a Code Man -_-!
 */
public class MyThread extends Thread{

    //1 创建（new）状态: 准备好了一个多线程的对象
    //2 就绪（runnable）状态: 调用了start()方法, 等待CPU进行调度
    //3 运行（running）状态: 执行run()方法
    //4 阻塞（blocked）状态: 暂时停止执行, 可能将资源交给其它线程使用
    //5 终止（dead）状态: 线程销毁

    private static int num = 0;

    public MyThread(){
        num++;
    }

    //run方法中只是定义需要执行的任务
    @Override
    public void run() {
        System.out.println("主动创建的第"+num+"个线程");
    }



    public static void main(String[] args)  {
        MyThread thread = new MyThread();
        thread.start();
    }
}
