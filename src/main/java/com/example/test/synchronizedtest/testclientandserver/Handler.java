package com.example.test.synchronizedtest.testclientandserver;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/20
 * @Time: 16:21
 * I am a Code Man -_-!
 */
public class Handler {

    private boolean isClientRequest = false;

    public void sendRequest(){
        synchronized (this){
            isClientRequest = true;
            System.out.println("客户端发送请求");
            this.notifyAll();
        }
    }

    public void waitResponse() throws InterruptedException {
        synchronized (this){
            while (isClientRequest){
                System.out.println("等待服务端的响应");
                this.wait();
            }
        }
    }

    public void receiveRequest(){
        synchronized (this) {
            isClientRequest = false;
            System.out.println("处理客户端请求");
            this.notifyAll();
        }
    }

    public void waitRequest() throws InterruptedException {
        synchronized (this){
            while (!isClientRequest){
                System.out.println("等待客户端请求");
                this.wait();
            }
        }
    }
}
