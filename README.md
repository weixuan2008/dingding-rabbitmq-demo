# Rabbitmq demo

This is a simple demo that using springboot tech stack, mainly focusing on usage of producer confirm and consumer acknowledgements.
Delivery processing acknowledgements from consumers to RabbitMQ are known as acknowledgements in AMQP, and broker acknowledgements to publishers are a protocol extension called publisher confirms.


Architecture diagram:
-------------------
![image](https://github.com/weixuan2008/dingding-rabbitmq-demo/blob/master/dingding%20rabbitmq.png)


Requirements: 
-------------------
1. This tutorial assumes RabbitMQ is installed and running on localhost on standard port (5672).
   In case you use a different host, port or credentials, connections settings would require adjusting.
2. Add appropriate rabbitmq user that will be used by below demo.
3. maven installed




Getting started:
-------------------	

From the command line with Maven installed:

	1. For producer
	$ cd tech-rabbitmq-producer
	$ change properties configuration according to your env
	$ mvn clean package -Dmaven.test.skip=true
	$ java -jar \target\tech-rabbitmq-producer-0.0.1-SNAPSHOT.jar
	


	2. For consumer
	$ cd tech-rabbitmq-consumer
	$ change properties configuration according to your env
	$ mvn clean package -Dmaven.test.skip=true
	$ java -jar \target\tech-rabbitmq-consumer-0.0.1-SNAPSHOT.jar


	3. monitor message in rabbitmq
	$ access the below url
	  eg. http://localhost:15672/#/queues
	



The official link for confirm detail
-------------------
http://www.rabbitmq.com/confirms.html

https://docs.spring.io/spring-amqp/reference/pdf/spring-amqp-reference.pdf
