package tech.points.rabbitmq.producer.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomConfirmCallback implements ConfirmCallback {
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		log.info("message unique id：" + correlationData);
		log.info("confirm result：" + ack);
		log.info("failure reasone：" + cause);
	}

}
