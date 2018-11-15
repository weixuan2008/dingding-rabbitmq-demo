# dingding rabbitmq demo

This is a simple demo that using springboot tech stack, mainly focusing on usage of producer confirm and consumer acknowledgements.



1. Requirements: 
-------------------
1. maven installed
2. Rabbitmq installed 
3. rabbitmq user added that will be used by below demo.



2. Getting started:
-------------------	
From the command line with Maven installed:
	1. For producer
	$ cd tech-rabbitmq-producer
	$ change properties configuration according to your env
	$ mvn clean package -Dmaven.test.skip=true
	$ java -jar \target\tech-rabbitmq-producer-0.0.1-SNAPSHOT.jar
	


	2. For producer
	$ cd tech-rabbitmq-consumer
	$ change properties configuration according to your env
	$ mvn clean package -Dmaven.test.skip=true
	$ java -jar \target\tech-rabbitmq-consumer-0.0.1-SNAPSHOT.jar


	3. monitor message in rabbitmq
	$ access the below url
	  eg. http://localhost:15672/#/queues
	


3. Architecture diagram:
-------------------
![image](https://github.com/weixuan2008/dingding-monolith/blob/master/dingding-monolith-master/core/dingding-micro-service/src/main/resources/static/images/order.PNG)
