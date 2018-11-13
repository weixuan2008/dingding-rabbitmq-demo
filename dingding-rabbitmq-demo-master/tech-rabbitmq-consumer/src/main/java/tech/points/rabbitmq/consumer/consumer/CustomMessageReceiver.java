package tech.points.rabbitmq.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import tech.points.rabbitmq.common.model.Product;

import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.Queue;
import java.io.IOException;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Exchange;

@Slf4j
@Component
@Configuration
public class CustomMessageReceiver {

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${dingding.order.queue.name}", durable = "true"), exchange = @Exchange(name = "${dingding.order.exchange.name}", durable = "true", type = "topic"), key = "${dingding.order.routing.key}"))
	public void receiveMessage(@Payload Product product, @Headers Map<String, Object> headers, Channel channel)
			throws IOException {

		Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

		if (headers.get("error") != null) {
			// channel.basicReject(deliveryTag,false);
			channel.basicNack(deliveryTag, false, true);
			log.info("Received an error msg and nack to broker, message: " + product.toString());
		} else {
			channel.basicAck(deliveryTag, false);
			log.info("Received msg and send ack to broker, message: " + product.toString());
		}
	}
}
