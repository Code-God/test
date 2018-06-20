package com.example.test.synchronizedtest.testclientandserver;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 16:22
 * I am a Code Man -_-!
 */
public class Client implements Runnable {

    private Handler handler;

    public Client(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(1);
                this.handler.sendRequest();//第二步
                this.handler.waitResponse();//第三步
            }
        } catch (InterruptedException e) {

        }
        System.out.println("客户端已经完成请求");
    }

    public static void main(String[] args) {
        Handler handler = new Handler();
        Client client = new Client(handler);
        Server server = new Server(handler);

        Thread thread1 = new Thread(client);
        Thread thread2 = new Thread(server);
        thread1.start();
        thread2.start();
    }
}
