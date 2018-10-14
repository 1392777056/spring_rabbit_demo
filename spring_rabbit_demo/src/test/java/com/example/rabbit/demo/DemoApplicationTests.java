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
		rabbitTemplate.convertAndSend("mao","直接模式要发送的信息");
	}

	/**
	 * 分列模式，在mao和yang队列中发送消息 ---- 使用了交换器（exchange）
	 */
	@Test
	public void testFanoutModelQueue() {
		rabbitTemplate.convertAndSend("zhangexchange","","分列模式 你好啊");
	}

	/**
	 * 主题模式，在mao和yang和qin队列中发送消息 ---- 也使用了交换器（exchange）
	 * 重点：一个消息被多个消费者消费
	 *
	 * 要求：
	 * 		瞬时：Transient
	 * 			必须有订阅者，才能发布消息
	 *		持久：Durable
	 *			没有瞬时的要求
	 *
	 *  topic 的路由规则 RoutingKey
	 *  mao: goods.#
	 *  qin: gong.log
	 *  yang: #.log
	 *
	 *  知识介绍：
	 *  # ：代表模糊查询
	 *  . ：分割
	 *  * ：只能代表 . 后面的一个单词
	 *
	 */
	@Test
	public void testTopicModelQueue() {
		rabbitTemplate.convertAndSend("dzexchange","gong.log","主题模式的测试");
	}

}
