package com.example.rabbit.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用于生产信息：
 * 		里面主要包含：
 * 			直接模式
 * 			分列模式
 * 			主题模式
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 直接模式，在mao队列中发送消息
	 */
	@Test
	public void testDirectModelQueue() {
		rabbitTemplate.convertAndSend("mao","要发送的信息");
	}

}
