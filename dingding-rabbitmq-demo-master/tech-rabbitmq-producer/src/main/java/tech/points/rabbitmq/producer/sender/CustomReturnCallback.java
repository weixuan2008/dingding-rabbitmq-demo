package tech.points.rabbitmq.producer.sender;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomReturnCallback implements ReturnCallback {

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		log.info("message: " + message);
		log.info("replyCode: " + replyCode);
		log.info("replyText：" + replyText);
		log.info("exchange: " + exchange);
		log.info("routingKey: " + routingKey);
	}

}
