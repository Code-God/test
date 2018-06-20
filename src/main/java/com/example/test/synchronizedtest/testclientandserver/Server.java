package com.example.test.synchronizedtest.testclientandserver;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 16:22
 * I am a Code Man -_-!
 */
public class Server implements Runnable {

    public Handler handler;

    public Server(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
//                System.out.println("等待客户端请求");
                this.handler.waitRequest();//第一步
//                System.out.println("处理客户端请求");
                TimeUnit.SECONDS.sleep(1);
                this.handler.receiveRequest();//第四步
            }
        } catch (InterruptedException e) {

        }
        System.out.println("服务端处理已经完成");
    }
}
