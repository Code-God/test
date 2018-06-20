package com.example.test.synchronizedtest;

/**
 * @Author: wuxiaobiao
 * @Description: 账户操作类
 * @Date: Created in 2018/6/20
 * @Time: 14:37
 * I am a Code Man -_-!
 */
public class AccountOperator implements Runnable{

    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    public void run() {
        synchronized (account) {
            account.deposit(500);//存钱
            account.withdraw(500);//取钱
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }


    public static void main(String args[]){

        Account account = new Account("张三", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i ++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }
    }
}
