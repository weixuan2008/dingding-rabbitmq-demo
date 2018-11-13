package tech.points.rabbitmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description TODO
 * @author Eddie.Wei
 * @github: https://github.com/weixuan2008
 * @creatTime 2018-11-12
 */

@SpringBootApplication
public class MQConsumer {
	public static void main(String[] args) {
		SpringApplication.run(MQConsumer.class, args);
	}
}
