package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 16:07
 * I am a Code Man -_-!
 */
public class Waiter implements Runnable{

    private Temp temp;

    public Waiter(Temp temp) {
        this.temp = temp;
    }

    public void run() {
        try {
            temp.waiter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
