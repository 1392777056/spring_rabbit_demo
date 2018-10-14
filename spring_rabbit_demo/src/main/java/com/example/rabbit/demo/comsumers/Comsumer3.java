package com.example.rabbit.demo.comsumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/10/14 13:32
 */
@Component
public class Comsumer3 {

    @RabbitHandler
    @RabbitListener(queues = "qin")
    public void showMessage(String message) {
        System.out.println("qin消费的消息：" + message);
    }

}
