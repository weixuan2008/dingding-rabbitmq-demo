package tech.points.rabbitmq.producer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import tech.points.rabbitmq.common.model.Company;
import tech.points.rabbitmq.common.model.Product;
import tech.points.rabbitmq.common.utils.UIDGenerator;
import tech.points.rabbitmq.producer.sender.CustomMessageSender;

/**
 * @description TODO 
 * @author Eddie.Wei
 * @github: https://github.com/weixuan2008
 * @creatTime 2018-11-12
 */

@Slf4j
@Component
public class PaceSendWorker {
	@Autowired
	private CustomMessageSender customMessageSender;
	
	@Scheduled(fixedDelay = 1000 * 60)
	public void makingProduct() {
		Company apple = new Company();
		apple.setId(UIDGenerator.genCompanyID());
		apple.setName("Apple Inc.");

		Product iphone7 = new Product();
		iphone7.setId(UIDGenerator.genProductID());
		iphone7.setName("Iphone 7");
		log.info("Making a {}, id is: {}", iphone7.getName(), iphone7.getId());
		
		Product iPadPro = new Product();
		iPadPro.setId(UIDGenerator.genProductID());
		iPadPro.setName("IPadPro");
		log.info("Making a {}, id is: {}", iPadPro.getName(), iPadPro.getId());
		
		iphone7.setCompany(apple);
		iPadPro.setCompany(apple);

		customMessageSender.sendMsg(iphone7);
		log.info("Sending a {}, id is: {}", iPadPro.getName(), iPadPro.getId());
		
		customMessageSender.sendMsg(iPadPro);
		log.info("Sending a {}, id is: {}", iPadPro.getName(), iPadPro.getId());
	}
}
