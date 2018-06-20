package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 16:08
 * I am a Code Man -_-!
 */
public class Notifyer implements Runnable{

    private Temp temp;

    public Notifyer(Temp temp){
        this.temp = temp;
    }
    public void run() {
        try {
            temp.notifyer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
