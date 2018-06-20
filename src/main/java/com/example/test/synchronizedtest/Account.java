package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description: 银行账户类
 * @Date: Created in 2018/6/20
 * @Time: 14:38
 * I am a Code Man -_-!
 */
public class Account {

    String name;

    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }
    //存钱
    public  void deposit(float amt) {
        amount += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //取钱
    public  void withdraw(float amt) {
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amount;
    }
}
