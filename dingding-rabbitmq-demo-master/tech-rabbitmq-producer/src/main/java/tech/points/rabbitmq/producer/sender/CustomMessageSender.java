package tech.points.rabbitmq.producer.sender;

import javax.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import tech.points.rabbitmq.common.model.Product;

@Slf4j
@Component
@Configuration
public class CustomMessageSender{
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(new CustomConfirmCallback());
        rabbitTemplate.setReturnCallback(new CustomReturnCallback());
    }
	
	@Value("${dingding.order.exchange.name}")
	private String exchange;

	@Value("${dingding.order.routing.key}")
	private String routingKey;

	public void sendMsg(Product product) {
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(product.getId());
		
		rabbitTemplate.convertAndSend(exchange, routingKey, product, correlationData);
		
		log.info("Sent msg, message: " + product.toString());
	}
}
