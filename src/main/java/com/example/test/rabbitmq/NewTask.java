package com.example.test.rabbitmq;

import com.rabbitmq.client.*;

/**
 * @Author: wuxiaobiao
 * @Description:  工厂任务安排者（生产者P）NewTask.java
 * @Date: Created in 2018/6/27
 * @Time: 09:51
 * I am a Code Man -_-!
 */
public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列
        //参数分别为，队列名字，是否持久化，独占的queue， 不使用时是否自动删除，其他参数
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        //分发消息
        for(int i = 0 ; i < 5; i++) {
            String message = "Hello World! " + i;
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }

}
