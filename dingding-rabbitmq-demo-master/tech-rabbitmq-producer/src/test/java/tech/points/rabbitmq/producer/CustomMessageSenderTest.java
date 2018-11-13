package tech.points.rabbitmq.producer;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tech.points.rabbitmq.common.model.Company;
import tech.points.rabbitmq.common.model.Product;
import tech.points.rabbitmq.producer.sender.CustomMessageSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomMessageSenderTest {
	@Autowired
	private CustomMessageSender customMessageSender;

	// @Test
	public void contextLoads() {
	}

	@Test
	public void testSendMsgTriple() throws Exception {
		for (int i = 0; i < 3; i++) {
			testSendMsgOnce();
		}
	}

	public void testSendMsgOnce() throws Exception {
		Company apple = new Company();
		apple.setId("100029100001");
		apple.setName("Apple Inc.");

		Product iphone7 = new Product();
		iphone7.setId(UUID.randomUUID().toString());
		iphone7.setName("Iphone 7");

		Product iPadPro = new Product();
		iPadPro.setId(UUID.randomUUID().toString());
		iPadPro.setName("IPadPro");

		iphone7.setCompany(apple);
		iPadPro.setCompany(apple);

		customMessageSender.sendMsg(iphone7);
		customMessageSender.sendMsg(iPadPro);
	}

}
