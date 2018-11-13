package tech.points.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	@Value("${dingding.order.queue.name}")
	String queueName;

	@Value("${dingding.order.exchange.name}")
	String exchangeName;

	@Value("${dingding.order.routing.key}")
	private String routingkey;

	@Value("${dingding.order.binding.key}")
	private String bindingKey;

	@Bean
	Queue queue() {
		return new Queue(queueName, true);
	}

	@Bean
	public TopicExchange dingdingExchange() {
		return new TopicExchange(exchangeName, true, false);
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(dingdingExchange()).with(routingkey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());

		return rabbitTemplate;
	}
}
