package tech.points.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description TODO 
 * @author Eddie.Wei
 * @github: https://github.com/weixuan2008
 * @creatTime 2018-11-12
 */

@EnableScheduling
@SpringBootApplication
public class MQProducer {
	public static void main(String[] args) {
		SpringApplication.run(MQProducer.class, args);
	}
}
